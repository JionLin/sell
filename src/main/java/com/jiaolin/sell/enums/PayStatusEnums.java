package com.jiaolin.sell.enums;

import lombok.Getter;

/**
 * @Auther: Joinlin
 * @Descriptional: 支付状态
 * @Date: Create in 15:40 2018/4/25
 * @Modify By:
 */
@Getter
public enum PayStatusEnums implements CodeEnum{
	WAIT(0,"等待支付"),
	SUCCESS(1,"支付成功"),
	;
	private Integer code;
	private String message;

	PayStatusEnums(Integer code, String message) {
		this.code = code;
		this.message = message;
	}


}
