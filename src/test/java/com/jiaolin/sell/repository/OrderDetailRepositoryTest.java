package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void save(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1112");
        orderDetail.setOrderId("110112");
        orderDetail.setProductIcon("xx.jpg");
        orderDetail.setProductId("111");
        orderDetail.setProductName("红烧肉");
        orderDetail.setProductPrice(new BigDecimal(15));
        orderDetail.setProductQuantity(100);
        repository.save(orderDetail);
    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("110112");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}