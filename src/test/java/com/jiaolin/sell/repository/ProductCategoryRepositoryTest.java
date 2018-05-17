package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * 进行测试
 * SpringBootTest
 * RunWith(SpringRunner.class)
 */
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository repository;

	@Test
	public void testSave(){
		ProductCategory productCategory=new ProductCategory();
		productCategory.setCategoryName("红烧猪脚");
		productCategory.setCategoryType(2);
		productCategory.setCategoryId(3);
		repository.save(productCategory);
	}


	
	/*
	 * @author joinlin
	 * @date 2018/4/20 11:46
	 * @param [id]
	 * @return void
	 * @Descriptional:根据id进行查询
	 */
	@Test
	public void findOne(){
		Optional<ProductCategory> optional = repository.findById(1);
		Assert.assertEquals(new Integer(1),optional.get().getCategoryType());
	}

	/*
	 * @author joinlin
	 * @date 2018/4/20 14:15
	 * @param
	 * @return
	 * @Descriptional: 根据类目的集合进行查询
	 */

	@Test
	public void findCategoryList(){
		List<Integer> list = Arrays.asList(1,2,3);
		List<ProductCategory> byCategoryType = repository.findByCategoryTypeIn(list);
		Assert.assertNotEquals(0,byCategoryType.size());
	}

	@Test
	public  void findAll(){
		List<ProductCategory> productCategoryList = repository.findAll();
		for (ProductCategory productCategory : productCategoryList) {
			System.out.println(productCategory.toString());
		}
	}

}