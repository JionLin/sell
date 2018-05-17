package com.jiaolin.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jiaolin.sell.dataobject.OrderDetail;
import com.jiaolin.sell.enums.OrderStatusEnums;
import com.jiaolin.sell.enums.PayStatusEnums;
import com.jiaolin.sell.utils.EnumUtil;
import com.jiaolin.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单数据传输对象
 */
@Data
public class OrderDTO {
    //订单id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家的openid
    private String buyerOpenid;

    //订单总数
    private BigDecimal orderAmount;

    //订单状态
    private Integer orderStatus;

    //支付状态 默认状态为0
    private Integer payStatus;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //修改时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    //订单详情表
    List<OrderDetail> orderDetailList;

    //根据所对应的字段,进行显示所对应的message
    @JsonIgnore
    public OrderStatusEnums getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnums.class);
    }

    //显示所对应的支付值
    @JsonIgnore
    public PayStatusEnums getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnums.class);

    }
}
