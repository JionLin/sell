package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.ProductCategory;
import com.jiaolin.sell.dataobject.ProductInfo;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @Auther:Joinlin
 * @Descriptional:
 * @Date: Create in 12:38 2018/4/23
 * @Modify By:商品详情表dao的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

	@Autowired
	private ProductInfoRepository repository;
	/*
	 * @author joinlin
	 * @date 2018/4/23 12:43
	 * @param []
	 * @return void
	 * @Descriptional: 查询所有
	 */
	@Test
	public void getList(){
		List<ProductInfo> productInfoList = repository.findAll();
		Assert.assertNotEquals(0,productInfoList.size());
	}

	/*
	 * @author joinlin
	 * @date 2018/4/23 12:49
	 * @param []
	 * @return void
	 * @Descriptional: 根据id进行查询
	 */
	@Test
	public void findById(){
		Optional<ProductInfo> byId = repository.findById("1");
		System.out.println(byId.get().getProductName());
	}


	@Test
	public void testSave(){
		ProductInfo productInfo=new ProductInfo();
		productInfo.setProductStock(100);
		productInfo.setProductId("111");
		productInfo.setCategoryType(2);
		productInfo.setProductDescription("味道足");
		productInfo.setProductIcon("http:xxx.jpg");
		productInfo.setProductName("驴肉");
		productInfo.setProductStatus(2);
		productInfo.setProductPrice(new BigDecimal(188));
		repository.save(productInfo);
	}

}