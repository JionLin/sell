package com.jiaolin.sell.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 9:13 2018/4/24
 * @Modify By:
 */
@Data
public class ProductInfoVo {
//id name price description icon
	@JsonProperty("id")
	private String productId;

	@JsonProperty("name")
	private String productName;

	@JsonProperty("price")
	private BigDecimal productPrice;

	@JsonProperty("description")
	private String productDescription;

	@JsonProperty("icon")
	private String productIcon;

}
