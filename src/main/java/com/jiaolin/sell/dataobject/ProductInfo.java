package com.jiaolin.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jiaolin.sell.enums.ProductStatusEnum;
import com.jiaolin.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
 * @author joinlin
 * @date 2018/4/20 11:57
 * @param  Entity:实体类 DynamicUpdate:动态更新  Data: get set tostring
 * @return
 * @Descriptional:
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
	@Id
	//主键,商品的id
	private String productId;

	//商品的名字
	private String productName;

	//商品的单价 bigDecimal 用于精确的计算金额
	private BigDecimal productPrice;

	//商品的库存
	private Integer productStock;
	//商品描述
	private String productDescription;
	//商品小图
	private String productIcon;

	//商品状态
	private Integer productStatus=ProductStatusEnum.UP.getCode();
	//类目编号
	private Integer categoryType;

	private Date createTime;
	private Date updateTime;

	//获得商品上下架的信息
	@JsonIgnore
	public ProductStatusEnum getProductStatusEnum(){
		return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
	}
}
