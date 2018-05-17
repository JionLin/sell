package com.jiaolin.sell.service.impl;

import com.jiaolin.sell.dataobject.OrderDetail;
import com.jiaolin.sell.dto.OrderDTO;
import com.jiaolin.sell.enums.OrderStatusEnums;
import com.jiaolin.sell.enums.PayStatusEnums;
import com.jiaolin.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 14:34 2018/4/26
 * @Modify By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
	public final String OPEN_ID = "110110";

	public final String ORDER_ID = "1524725990329985792";
	@Autowired
	private OrderService orderService;

	/**
	 * 创建订单
	 *
	 * @throws Exception
	 */
	@Test
	public void create() throws Exception {
		OrderDTO orderDTO = new OrderDTO();

		orderDTO.setBuyerAddress("join");
		orderDTO.setBuyerOpenid(OPEN_ID);
		orderDTO.setBuyerPhone("12345678901");
		orderDTO.setBuyerName("小黑");

		List<OrderDetail> orderDetailList = new ArrayList<>();
		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setProductId("11");
		orderDetail.setProductQuantity(5);
		orderDetailList.add(orderDetail);

		orderDTO.setOrderDetailList(orderDetailList);

		OrderDTO result = orderService.create(orderDTO);
		log.info("[创建订单],result={}", result);
		Assert.assertNotNull(result);
	}


	@Test
	public void findByOrderId() throws Exception {
		OrderDTO result = orderService.findByOrderId(ORDER_ID);
		log.info("{订单id},result={}", result);
		Assert.assertEquals(result.getOrderId(), "1524746356987472970");
	}

	@Test
	public void findList() throws Exception {
		PageRequest pageRequest = new PageRequest(0, 3);
		Page<OrderDTO> list = orderService.findList("110110", pageRequest);
		Assert.assertNotEquals(0, list.getTotalElements());

	}

	@Test
	public void cancle() throws Exception {
		//获取订单的状态
		OrderDTO orderId = orderService.findByOrderId(ORDER_ID);

		OrderDTO orderDTO = orderService.cancle(orderId);

		Assert.assertEquals(orderDTO.getOrderStatus(), OrderStatusEnums.CANCLE.getCode());

	}

	@Test
	public void paid() throws Exception {
		OrderDTO orderDTO = orderService.findByOrderId(ORDER_ID);
		OrderDTO result = orderService.paid(orderDTO);
		Assert.assertEquals(result.getPayStatus(), PayStatusEnums.SUCCESS.getCode());
	}

	@Test
	public void finish() throws Exception {
		OrderDTO orderDTO = orderService.findByOrderId(ORDER_ID);
		OrderDTO result = orderService.finish(orderDTO);
		Assert.assertEquals(result.getOrderStatus(),OrderStatusEnums.FINISH.getCode());
	}

	@Test
	public void findList1() throws Exception {
		PageRequest pageRequest=new PageRequest(0,10);
		Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
		Assert.assertTrue("查询订单列表错误",orderDTOPage.getTotalPages()>0);
	}

}