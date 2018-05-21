package com.jiaolin.sell.service.impl;

import com.jiaolin.sell.dto.OrderDTO;
import com.jiaolin.sell.service.OrderService;
import com.jiaolin.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: Joinlin
 * @Descriptional: 微信模板消息推送
 * @Date: Create in 16:47 2018/5/21
 * @Modify By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {
	@Autowired
	private PushMessageService pushMessageService;

	@Autowired
	private OrderService orderService;
	@Test
	public void orderStatus() throws Exception {
		OrderDTO orderDTO = orderService.findByOrderId("110110");
		pushMessageService.OrderStatus(orderDTO);
	}

}