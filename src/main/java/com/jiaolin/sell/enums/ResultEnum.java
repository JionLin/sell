package com.jiaolin.sell.enums;

import lombok.Getter;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 9:54 2018/4/26
 * @Modify By:
 */
@Getter
public enum ResultEnum {

	PARAM_ERROR(1,"参数错误"),

	PRODUCT_NOT_EXIST(10,"商品不存在"),

	PRODUCT_STOCK_ERROR(11,"商品库存不足"),

	ORDER_NOT_EXIST(12,"订单不存在"),

	ORDER_DETAIL_EXIST(13,"订单详情不存在"),

	ORDER_STATUS_ERROR(14,"订单状态错误"),

	ORDER_UPDATE_FAIL(15,"订单更新失败"),

	ORDER_DETAIL_ERROR(16,"订单商品为空"),

	ORDER_PAY_FAIL(17,"订单支付状态不正确"),

	ORDER_PAYSTATUS_FAIL(18,"订单支付更新失败"),

	ORDER_FINISH_FAIL(19,"订单完结状态失败"),

	ORDER_FORM_ERROR(20,"买家订单表单输入异常"),

	ORDER_NOT_OWNER(21,"订单不属于当前用户"),

	WECHAT_MP_ERROR(22,"微信网页信息错误"),

	WXPAY_NOTIFY_MONEY_VERIFY_ERROR(23,"微信支付通知信息异常"),

	ORDER_CANCEL_SUCCESS(24,"订单取消成功"),

	ORDER_FINISH_SUCCESS(25,"订单完结成功"),

	PRODUCT_STATUS_ERROR(26,"商品状态异常"),
	;

	private Integer code;
	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
