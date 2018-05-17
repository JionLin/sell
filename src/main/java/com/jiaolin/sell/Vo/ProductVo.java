package com.jiaolin.sell.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 9:13 2018/4/24
 * @Modify By:
 */
@Data
public class ProductVo {
//	name  type  foods

	@JsonProperty("name")
	private String categoryName;

	@JsonProperty("type")
	private Integer categoryType;

	@JsonProperty("foods")
	private List<ProductInfoVo> productInfoVoList;
}
