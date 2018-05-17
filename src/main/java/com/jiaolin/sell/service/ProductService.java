package com.jiaolin.sell.service;

import com.jiaolin.sell.dataobject.ProductInfo;
import com.jiaolin.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther:Joinlin
 * @Descriptional:商品类目
 * @Date: Create in 16:13 2018/4/20
 * @Modify By:
 */
public interface ProductService {
	//根据id进行查询
	//Optional<ProductInfo> findById(String productId);
	ProductInfo findById(String productId);

	//查询所有在架商品
	List<ProductInfo> findUpAll();
	//查询所有商品
	Page<ProductInfo> findAll(Pageable pageable);

	//商品保存
	ProductInfo sava(ProductInfo productInfo);

	//加库存
	void increaseStock(List<CartDTO> cartDTOList);

	//减库存
	void decreaseStock(List<CartDTO> cartDTOList);

	//上架
	ProductInfo onSale(String productId);

	//下架
	ProductInfo offSale(String productId);
}
