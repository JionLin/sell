package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.SellInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:45 2018/5/17
 * @Modify By:
 */
public interface SellInfoRepository extends JpaRepository<SellInfo,String>{
	//根据openid进行查询所对应的sellInfo
	SellInfo findByOpenid(String openid);
}
