package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.SellerInfo;
import com.jiaolin.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 10:53 2018/5/18
 * @Modify By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellInfoRepositoryTest {
	@Autowired
	private SellInfoRepository repository;
	@Test
	public void save(){
		SellerInfo sellerInfo =new SellerInfo();
		sellerInfo.setId(KeyUtil.getUniqueKey());
		sellerInfo.setOpenid("AAA");
		sellerInfo.setPassword("admin");
		sellerInfo.setUsername("admin");
		repository.save(sellerInfo);
	}

	@Test
	public void findByOpenid() throws Exception {

	}

}