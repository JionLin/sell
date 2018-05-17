package com.jiaolin.sell.controller;

import com.jiaolin.sell.dataobject.ProductCategory;
import com.jiaolin.sell.dataobject.ProductInfo;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.form.ProductForm;
import com.jiaolin.sell.service.CategroyService;
import com.jiaolin.sell.service.ProductService;
import com.jiaolin.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 10:31 2018/5/16
 * @Modify By: 卖家商品列表
 */
@Controller
@Slf4j
@RequestMapping("/seller/product")
public class SellProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategroyService categroyService;

    /**
     * 商品列表
     *
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("currentPage", page);
        map.put("size", size);
        map.put("productInfoPage", productInfoPage);
        return new ModelAndView("product/list", map);
    }

    /**
     * 商品上架
     *
     * @param productId 商品的id
     * @param map
     * @return
     */
    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            log.error("商品上架异常");
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 商品下架
     *
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            log.error("商品下架异常");
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }


    /**
     * 卖家单个商品列表的index
     * @param map
     * @param productId
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> map,
                              @RequestParam(value = "productId", required = false) String productId) {
        if (StringUtils.isNotEmpty(productId)) {
            ProductInfo productInfo = productService.findById(productId);
            map.put("productInfo", productInfo);
        }
        //需要查询类目
        List<ProductCategory> categoryList = categroyService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index", map);
    }

    /**
     * 卖家新增/修改页面
     *
     * @param map
     * @param bindingResult 进行字段的验证
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(Map<String, Object> map,
                             @Valid ProductForm form,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        //进行判断producntId是否为空 ,不为空时,就为修改
        try {
            if (StringUtils.isNotEmpty(form.getProductId())) {
                productInfo = productService.findById(form.getProductId());
            } else {
                //为新增
                form.setProductId(KeyUtil.getUniqueKey());
            }
            BeanUtils.copyProperties(form, productInfo);
            productService.sava(productInfo);

        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
