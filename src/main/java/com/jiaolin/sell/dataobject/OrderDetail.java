package com.jiaolin.sell.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jiaolin.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderDetail {
	//详情id
	@Id
	private String detailId;

	//订单id
	private String orderId;

	//商品id
	private String productId;

	//商品名字
	private String productName;

	//商品单价
	private BigDecimal productPrice;

	//商品的数量
	private Integer productQuantity;

	//商品图片
	private String productIcon;

	//创建时间
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date createTime;

	//修改时间
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date updateTime;
}
