package com.jiaolin.sell.controller;

import com.jiaolin.sell.Vo.ProductInfoVo;
import com.jiaolin.sell.Vo.ProductVo;
import com.jiaolin.sell.Vo.ResultVo;
import com.jiaolin.sell.dataobject.ProductCategory;
import com.jiaolin.sell.dataobject.ProductInfo;
import com.jiaolin.sell.service.CategroyService;
import com.jiaolin.sell.service.ProductService;
import com.jiaolin.sell.utils.ResultVoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Joinlin
 * @Descriptional: /sell/buyer/product/list 获取商品的列表
 * @Date: Create in 9:10 2018/4/23
 * @Modify By:
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategroyService categroyService;

    @GetMapping("/list")
    public ResultVo getProductList() {
        //进行所有上架商品的查询
        List<ProductInfo> productInfoList = productService.findUpAll();

        //进行所有类目的查询
  /*      List<Integer> categoryTypeList = new ArrayList<>();
        //类目查询,进行添加到集合中去
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryTypeList = categroyService.findByCategoryTypeIn(categoryTypeList);

        //进行数据的拼接,类目里面嵌套商品的详情,先查询外面的
        List<ProductVo> productVoList=new ArrayList<>();
        for (ProductCategory productCategory : productCategoryTypeList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo>productInfoVoList =new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    //进行属性的copy spring提供的参数
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        return ResultVoUtils.success(productVoList);
    }
}
