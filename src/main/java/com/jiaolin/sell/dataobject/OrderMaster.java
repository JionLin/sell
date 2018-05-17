package com.jiaolin.sell.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jiaolin.sell.enums.OrderStatusEnums;
import com.jiaolin.sell.enums.PayStatusEnums;
import com.jiaolin.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


//订单主表
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
	//订单id
	@Id
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
	private Integer orderStatus= OrderStatusEnums.NEW.getCode();

	//支付状态 默认状态为0
	private Integer payStatus= PayStatusEnums.WAIT.getCode();

	//创建时间
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date createTime;

	//修改时间
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date updateTime;
}
