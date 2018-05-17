package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
	/*
	 * @author joinlin
	 * @date 2018/4/20 16:19
	 * @param [categoryTypeList]
	 * @return java.util.List<com.jiaolin.sell.dataobject.ProductCategory>
	 * @Descriptional: 根据类目的编号进行查询商品类目 需要加In才行,根据jpa的语法
	 */
	List<ProductCategory> findByCategoryTypeIn(List<Integer>categoryTypeList);
}
