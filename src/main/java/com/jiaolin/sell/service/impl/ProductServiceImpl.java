package com.jiaolin.sell.service.impl;

import com.jiaolin.sell.dataobject.ProductInfo;
import com.jiaolin.sell.dto.CartDTO;
import com.jiaolin.sell.enums.ProductStatusEnum;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.repository.ProductInfoRepository;
import com.jiaolin.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @Auther:Joinlin
 * @Descriptional:
 * @Date: Create in 16:21 2018/4/20
 * @Modify By:
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductInfoRepository repository;

	@Override
	public ProductInfo findById(String productId) {
		return repository.findById(productId).get();
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductInfo sava(ProductInfo productInfo) {
		return repository.save(productInfo);
	}

	@Override
	@Transactional
	public void increaseStock(List<CartDTO> cartDTOList) {
		//增加商品的库存
		//1 进行购物车商品的遍历
		for (CartDTO cartDTO : cartDTOList) {
			//2根据购物车id进行商品信息的查询
			Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
			//3如果商品不存在,抛出异常
			if (!productInfo.isPresent()){
				log.error("商品不存在");
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			//4进行库存的增加
			Integer number=productInfo.get().getProductStock()+cartDTO.getProductQuantity();
			//5商品重新设置库存
			productInfo.get().setProductStock(number);
			//进行商品的保存
			repository.save(productInfo.get());
		}


	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		//库存的减少-->根据购物车进行商品id的查询-->进行库存的比较,商品信息的数量-购物车的数量是否大于0-->进行商品数量的设置,并保持
		//根据传进来的购物车详情进行判断,进行遍历,商品repository根据id进行查询出来你productInfo,
		for (CartDTO cartDTO : cartDTOList) {
			Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
			if (!productInfo.isPresent()) {
				log.error("商品信息不存在,result={}", productInfo.get().getProductId());
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			//
			Integer number = productInfo.get().getProductStock() - cartDTO.getProductQuantity();
			if (number < 0) {
				log.error("商品库存不足,result={}", number);
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			productInfo.get().setProductStock(number);
			repository.save(productInfo.get());
		}
	}

	/**
	 * 商品上架
	 * @param productId
	 * @return
	 */
	@Override
	public ProductInfo onSale(String productId) {
		//1 先查询商品的id,进行商品的查询
		Optional<ProductInfo> productInfo = repository.findById(productId);

		if (!productInfo.isPresent()){
			log.error("商品上架异常,result={}",productInfo.get().getProductId());
			throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
		}
		//2 进行状态的判断
		if (productInfo.get().getProductStatus()==ProductStatusEnum.UP.getCode()){
			log.error("商品状态异常");
			throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
		}

		//3	进行商品的状态修改
		productInfo.get().setProductStatus(ProductStatusEnum.UP.getCode());
		return repository.save(productInfo.get());
	}

	/**
	 * 商品下架
	 * @param productId
	 * @return
	 */
	@Override
	public ProductInfo offSale(String productId) {
		//1 先查询商品的id,进行商品的查询
		Optional<ProductInfo> productInfo = repository.findById(productId);

		if (!productInfo.isPresent()){
			log.error("商品下架异常,result={}",productInfo.get().getProductId());
			throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
		}
		//2 进行状态的判断
		if (productInfo.get().getProductStatus()==ProductStatusEnum.DOWN.getCode()){
			log.error("商品状态异常");
			throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
		}

		//3	进行商品的状态修改
		productInfo.get().setProductStatus(ProductStatusEnum.DOWN.getCode());
		return repository.save(productInfo.get());
	}
}
