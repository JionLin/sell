package com.jiaolin.sell.dto;

import lombok.Data;

/**
 * @Auther: Joinlin
 * @Descriptional:购物车
 * @Date: Create in 10:58 2018/4/26
 * @Modify By:
 */
@Data
public class CartDTO {
	//购物车的id
	private String productId;
	//购物车的数量
	private Integer productQuantity;


	public CartDTO(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
}
