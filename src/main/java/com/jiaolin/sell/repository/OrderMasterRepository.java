package com.jiaolin.sell.repository;

import com.jiaolin.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 15:57 2018/4/25
 * @Modify By:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{

	//根据buyerOpenid进行查询
	public Page<OrderMaster> findByBuyerOpenid(String buyOpenId, Pageable pageable);
}
