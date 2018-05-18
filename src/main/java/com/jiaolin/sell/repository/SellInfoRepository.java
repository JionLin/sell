package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:45 2018/5/17
 * @Modify By:
 */
public interface SellInfoRepository extends JpaRepository<SellerInfo,String>{
	//根据openid进行查询所对应的sellInfo
	SellerInfo findByOpenid(String openid);
}
