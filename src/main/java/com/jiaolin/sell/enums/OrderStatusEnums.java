package com.jiaolin.sell.enums;

import lombok.Getter;

/**
 * @Auther: Joinlin
 * @Descriptional: 订单状态
 * @Date: Create in 15:43 2018/4/25
 * @Modify By:
 */
@Getter
public enum OrderStatusEnums implements CodeEnum{
	NEW(0,"新订单"),
	FINISH(1,"已完结"),
	CANCLE(2,"已取消"),
	;
	private Integer code;
	private String message;

	OrderStatusEnums(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
