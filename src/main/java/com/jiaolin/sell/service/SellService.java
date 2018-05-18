package com.jiaolin.sell.service;

import com.jiaolin.sell.dataobject.SellerInfo;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:52 2018/5/17
 * @Modify By:
 */
public interface SellService {

	SellerInfo findByopenid(String openid);
}
