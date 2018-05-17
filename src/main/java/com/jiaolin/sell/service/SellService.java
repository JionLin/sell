package com.jiaolin.sell.service;

import com.jiaolin.sell.dataobject.SellInfo;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:52 2018/5/17
 * @Modify By:
 */
public interface SellService {

	SellInfo findByopenid(String openid);
}
