package com.jiaolin.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "名字不能为空")
    private String name;

    @NotEmpty(message = "手机号码不能为空")
    private String phone;

    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotEmpty(message = "用户微信openId不能为空")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
