package com.jiaolin.sell.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 11:31 2018/5/18
 * @Modify By:
 */
@Component
public class WechatOpenConfig {

	@Autowired
	private WechatAccountConfig accountConfig;

	/**
	 * 进行微信开放平台的设置
	 * @return
	 */
	@Bean
	public WxMpService wxOpenService(){
		WxMpService wxMpService=new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(wxOpenConfigStorage());
		return wxMpService;
	}

	/**
	 * 进行开放平台账号的设置
	 * @return
	 */
	@Bean
	public WxMpConfigStorage wxOpenConfigStorage(){
		WxMpInMemoryConfigStorage wxMpConfigStorage=new WxMpInMemoryConfigStorage();
		wxMpConfigStorage.setAppId(accountConfig.getOpenAppId());
		wxMpConfigStorage.setSecret(accountConfig.getOpenAppSecret());
		return wxMpConfigStorage;
	}
}
