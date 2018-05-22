package com.jiaolin.sell.service.impl;

import com.jiaolin.sell.convert.OrderMaster2OrderDTOConvert;
import com.jiaolin.sell.dataobject.OrderDetail;
import com.jiaolin.sell.dataobject.OrderMaster;
import com.jiaolin.sell.dataobject.ProductInfo;
import com.jiaolin.sell.dto.CartDTO;
import com.jiaolin.sell.dto.OrderDTO;
import com.jiaolin.sell.enums.OrderStatusEnums;
import com.jiaolin.sell.enums.PayStatusEnums;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.repository.OrderDetailRepository;
import com.jiaolin.sell.repository.OrderMasterRepository;
import com.jiaolin.sell.service.OrderService;
import com.jiaolin.sell.service.PayService;
import com.jiaolin.sell.service.ProductService;
import com.jiaolin.sell.service.WebScoket;
import com.jiaolin.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderMasterRepository orderMasterRepository;

	@Autowired
	private PayService payService;

	@Autowired
	private WebScoket webScoket;

	@Override
	@Transactional
	public OrderDTO create(OrderDTO orderDTO) {
		//创建订单的步骤-->进行订单详情的查询-->查询是否有订单-->计算总价-->把参数写入到orderMaster和OrderDetail里面-->进行库存的减少
		//0 先定义商品的价格 为0
		BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

		//定义商品的orderId
		String ORDER_ID = KeyUtil.getUniqueKey();
		//1查询商品,详情
		List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
		if (CollectionUtils.isEmpty(orderDetailList)) {
			log.error("订单详情不存在", orderDetailList);
			throw new SellException(ResultEnum.ORDER_DETAIL_EXIST);
		}
		//2根据商品详情的商品id进行查询商品是否存在
		for (OrderDetail orderDetail : orderDetailList) {
			ProductInfo productInfo = productService.findById(orderDetail.getProductId());
			if (productInfo ==null) {
				log.error("商品不存在");
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			//计算总价,类型不同的话,直接new
			orderAmount = productInfo.getProductPrice()
					.multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

			//把productInfo的参数copy到订单详情表中,方便于观看
			orderDetail.setOrderId(ORDER_ID);
			orderDetail.setDetailId(KeyUtil.getUniqueKey());
			BeanUtils.copyProperties(productInfo, orderDetail);
			orderDetailRepository.save(orderDetail);
		}
		//写入订单主表中 orderDTO写入进去
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(ORDER_ID);
		//把orderDTO的参数写入到orderMaster中
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());//设置支付的状态
		orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());//设置订单的状态
		orderMaster.setOrderAmount(orderAmount);//设置订单总价钱
		orderMasterRepository.save(orderMaster);

		//4进行库存的减少   CartDTO里面包含数量和商品的id,这里面orderDTO.getOrderDetailList()有包括这些,
		List<CartDTO> cartDTOList = orderDetailList.stream()
				.map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
		productService.decreaseStock(cartDTOList);

		webScoket.sendMessage(orderDTO.getOrderId());
		return orderDTO;
	}

	@Override
	public OrderDTO findByOrderId(String orderId) {
		OrderDTO orderDTO = new OrderDTO();
		List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
		if (CollectionUtils.isEmpty(orderDetailList)) {
			throw new SellException(ResultEnum.ORDER_DETAIL_EXIST);
		}

		Optional<OrderMaster> orderMaster = orderMasterRepository.findById(orderId);
		if (!orderMaster.isPresent()) {
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
		BeanUtils.copyProperties(orderMaster.get(), orderDTO);
		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
	}

	@Override
	public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
		//根据orderMaster的openid 进行分页查找
		Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
		//把List<OrderMaster> orderMasterList转换为 List<OrderDTO>
		List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConvert.converList(orderMasterPage.getContent());
		//返回分页的参数Page<OrderDTO>
		return new PageImpl<OrderDTO>(orderDTOList, pageable, orderMasterPage.getTotalElements());
	}

	@Override
	@Transactional
	public OrderDTO cancle(OrderDTO orderDTO) {
		//来判断订单
		OrderMaster orderMaster = new OrderMaster();

		if (!orderDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())) {
			log.error("[订单状态错误] orderId={},orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		//设置订单状态为2
		orderDTO.setOrderStatus(OrderStatusEnums.CANCLE.getCode());
		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster updateResult = orderMasterRepository.save(orderMaster);
		if (updateResult == null) {
			log.error("[订单状态更新失败],updateReult={}", updateResult);
			throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		}


		//加库存
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			log.error("[商品为空],orderDTO={}", orderDTO);
			throw new SellException(ResultEnum.ORDER_DETAIL_ERROR);
		}
		List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
				.map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
		productService.increaseStock(cartDTOList);
		//退钱
		//如果已支付, 需要退款PayStatusEnums
		if (orderDTO.getPayStatus().equals(PayStatusEnums.SUCCESS.getCode())) {
			payService.refund(orderDTO);
		}
		return orderDTO;
	}

	@Override
	@Transactional
	public OrderDTO paid(OrderDTO orderDTO) {
		//判断订单状态
		if (!orderDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())) {
			log.error("[订单支付状态] 订单状态不正确,orderStatus={}", orderDTO.getOrderStatus());
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		//判断支付状态
		if (!orderDTO.getPayStatus().equals(PayStatusEnums.WAIT.getCode())) {
			log.error("[订单支付状态] 订单支付状态不正确,payStatus={}", orderDTO.getPayStatus());
			throw new SellException(ResultEnum.ORDER_PAY_FAIL);
		}
		//修改支付状态
		//设置支付状态为完结状态
		orderDTO.setPayStatus(PayStatusEnums.SUCCESS.getCode());

		OrderMaster orderMaster = new OrderMaster();

		BeanUtils.copyProperties(orderDTO, orderMaster);
		//进行支付状态的保存
		OrderMaster result = orderMasterRepository.save(orderMaster);
		if (result == null) {
			log.error("[订单支付状态],更新失败,result={}", orderDTO.getPayStatus());
			throw new SellException(ResultEnum.ORDER_PAYSTATUS_FAIL);
		}
		//copy参数到orderDTO
		return orderDTO;
	}

	@Override
	@Transactional
	public OrderDTO finish(OrderDTO orderDTO) {

		//判断订单状态
		if (!orderDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())) {
			log.error("[订单完结状态],订单完结失败,result={}", orderDTO.getOrderStatus());
			throw new SellException(ResultEnum.ORDER_FINISH_FAIL);
		}
		//修改订单状态
		orderDTO.setOrderStatus(OrderStatusEnums.FINISH.getCode());

		OrderMaster orderMaster = new OrderMaster();

		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster result = orderMasterRepository.save(orderMaster);

		if (result == null) {
			log.error("[订单完结状态],订单完结状态更新失败,result={}", result.getOrderStatus());
			throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		}
		return orderDTO;
	}

	@Override
	public Page<OrderDTO> findList(Pageable pageable) {
		//根据orderMaster的openid 进行分页查找
		Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
		//把List<OrderMaster> orderMasterList转换为 List<OrderDTO>
		List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConvert.converList(orderMasterPage.getContent());
		//返回分页的参数Page<OrderDTO>
		return new PageImpl<OrderDTO>(orderDTOList, pageable, orderMasterPage.getTotalElements());
	}
}
