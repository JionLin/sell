package com.jiaolin.sell.controller;

import com.jiaolin.sell.dataobject.ProductCategory;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.form.CategoryForm;
import com.jiaolin.sell.service.CategroyService;
import com.jiaolin.sell.utils.KeyUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 10:51 2018/5/17
 * @Modify By:
 */
@Controller
@Slf4j
@RequestMapping("/seller/category")
public class SellCategoryController {

	@Autowired
	private CategroyService categroyService;
	/**
	 * 类目列表
	 * 类目的展示
	 * 类目的新增和修改
	 */

	/**
	 * 类目列表
	 *
	 * @param map 用来存储到视图的东西
	 * @return
	 */
	@GetMapping("/list")
	public ModelAndView list(Map<String, Object> map) {
		List<ProductCategory> categoryList = categroyService.findAll();
		map.put("categoryList", categoryList);
		return new ModelAndView("category/list", map);
	}


	@GetMapping("/index")
	public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
							  Map<String, Object> map) {
		if (categoryId != null) {
			ProductCategory category = categroyService.findById(categoryId);
			map.put("category", category);
		}
		return new ModelAndView("category/index", map);
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid CategoryForm form,
							 BindingResult bindingResult,
							 Map<String, Object> map) {
		//来判断是否是新增,还是修改
		ProductCategory category = new ProductCategory();
		try {
			if (form.getCategoryId() != null) {
				//为新增
				category = categroyService.findById(form.getCategoryId());
			}
			BeanUtils.copyProperties(form, category);
			categroyService.save(category);
		} catch (SellException e) {
			map.put("msg", e.getMessage());
			map.put("url", "/sell/seller/category/list");
			return new ModelAndView("common/error", map);
		}
		map.put("url","/sell/seller/category/list");
		return new ModelAndView("common/success", map);
	}
}
