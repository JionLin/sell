package com.jiaolin.sell.form;

import lombok.Data;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 10:59 2018/5/17
 * @Modify By:
 */
@Data
public class CategoryForm {

	private Integer categoryId;
	/**
	 * 商品名字
	 */
	private String categoryName;
	/**
	 * 商品类型
	 */
	private Integer categoryType;
}
