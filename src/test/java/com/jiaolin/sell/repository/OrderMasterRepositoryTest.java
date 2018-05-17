package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther: Joinlin
 * @Descriptional: 测试主表的参数
 * @Date: Create in 15:59 2018/4/25
 * @Modify By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
	@Autowired
	private OrderMasterRepository repository;

	private String OPENID="111";
	@Test
	public void save(){
		OrderMaster orderMaster=new OrderMaster();
		orderMaster.setOrderId("110110");
		orderMaster.setBuyerAddress("车公庙");
		orderMaster.setBuyerName("小白");
		orderMaster.setBuyerOpenid(OPENID);
		orderMaster.setOrderAmount(new BigDecimal(10));
		orderMaster.setPayStatus(0);
		orderMaster.setBuyerPhone("12345999812");
		orderMaster.setOrderStatus(0);
		repository.save(orderMaster);
	}
	@Test
	public void findByBuyerOpenid() throws Exception {
 		PageRequest request=new PageRequest(1,3);
		Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(OPENID, request);
		Assert.assertNotEquals(0,byBuyerOpenid.getTotalElements());
	}

}