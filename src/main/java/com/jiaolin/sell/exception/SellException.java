package com.jiaolin.sell.exception;

import com.jiaolin.sell.enums.ResultEnum;

/**
 * @Auther: Joinlin
 * @Descriptional: 自定义异常
 * @Date: Create in 9:51 2018/4/26
 * @Modify By:
 */
public class SellException extends RuntimeException{
	//错误码
	private Integer code;

	//错误码,信息,
	public SellException(Integer code,String message) {
		super(message);
		this.code = code;
	}

	public SellException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code=resultEnum.getCode();
	}
	public SellException(ResultEnum resultEnum,String message){
		super(message);
		this.code=resultEnum.getCode();
	}
}
