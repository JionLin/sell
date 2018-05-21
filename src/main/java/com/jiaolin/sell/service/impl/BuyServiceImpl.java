package com.jiaolin.sell.service.impl;

import com.jiaolin.sell.dto.OrderDTO;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.service.BuyService;
import com.jiaolin.sell.service.OrderService;
import com.jiaolin.sell.service.WebScoket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 11:33 2018/5/2
 * @Modify By:
 */
@Slf4j
@Service
public class BuyServiceImpl implements BuyService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private WebScoket webScoket;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOne(openId, orderId);
        return orderDTO;
    }

    @Override
    public OrderDTO cancle(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOne(openId, orderId);
        if (orderDTO==null){
            log.error("[取消订单],该订单不存在");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        webScoket.sendMessage("取消订单成功");
        return orderService.cancle(orderDTO);
    }

    //方法的提取
    private OrderDTO checkOrderOne(String openId, String orderId) {
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        if (orderDTO == null) {
          return null;
        }
        if (!orderDTO.getBuyerOpenid().equals(openId)){
            log.error("[查询订单],订单不一致");
            throw new SellException(ResultEnum.ORDER_NOT_OWNER);
        }
        return orderDTO;
    }
}
