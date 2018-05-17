package com.jiaolin.sell.service.impl;

import com.jiaolin.sell.dataobject.ProductCategory;
import com.jiaolin.sell.repository.ProductCategoryRepository;
import com.jiaolin.sell.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * @Auther:Joinlin
 * @Descriptional:
 * @Date: Create in 12:52 2018/4/23
 * @Modify By:
 */
@Service
public class CategroyServiceImpl implements CategroyService {

	@Autowired
	private ProductCategoryRepository repository;

	@Override
	public ProductCategory findById(Integer categoryId) {
		return repository.findById(categoryId).get();
	}

	@Override
	public List<ProductCategory> findAll() {
		return repository.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return repository.findByCategoryTypeIn(categoryTypeList);
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		return repository.save(productCategory);
	}
}
