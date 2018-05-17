package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    //根据订单主表的id进行查询订单详情,有多个
    List<OrderDetail> findByOrderId(String orderId);
}
