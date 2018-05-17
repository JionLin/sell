package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther:Joinlin
 * @Descriptional:
 * @Date: Create in 12:37 2018/4/23
 * @Modify By:
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    /**
     * 根据商品的状态查询商品集合
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
