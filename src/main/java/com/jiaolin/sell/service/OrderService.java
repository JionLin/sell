package com.jiaolin.sell.service;

import com.jiaolin.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    //创建订单,订单主表里面必须包含有一个订单详情 需要用到list ,创建一个dto data transaion object 数据传输对象
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
   OrderDTO findByOrderId(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    //取消订单
    OrderDTO cancle(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //查询订单列表
    Page<OrderDTO> findList(Pageable pageable);
}
