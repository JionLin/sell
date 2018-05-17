package com.jiaolin.sell.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {

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

    //类目编号
    private Integer categoryType;

}
