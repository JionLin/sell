package com.jiaolin.sell.service;

import com.jiaolin.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * @Auther:Joinlin
 * @Descriptional:
 * @Date: Create in 12:52 2018/4/23
 * @Modify By:
 */
public interface CategroyService {

	ProductCategory findById(Integer categoryId);

	List<ProductCategory> findAll();

	List<ProductCategory> findByCategoryTypeIn(List<Integer>categoryTypeList);

	ProductCategory save(ProductCategory productCategory);



}
