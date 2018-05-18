package com.jiaolin.sell.service.impl;

import com.jiaolin.sell.dataobject.SellerInfo;
import com.jiaolin.sell.repository.SellInfoRepository;
import com.jiaolin.sell.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:53 2018/5/17
 * @Modify By:
 */
@Service
public class SellServiceImpl implements SellService {
	@Autowired
	private SellInfoRepository repository;

	/**
	 * 根据openid获取卖家用户信息
	 * @param openid
	 * @return
	 */
	@Override
	public SellerInfo findByopenid(String openid) {
		return repository.findByOpenid(openid);
	}
}
