package com.jiaolin.sell.service;

import com.jiaolin.sell.dto.OrderDTO;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 11:31 2018/5/2
 * @Modify By:
 */
public interface BuyService {


    //查询一个订单
    public OrderDTO findOrderOne(String openId, String orderId);


    //取消一个订单
    public OrderDTO cancle(String openId, String orderId);
}
