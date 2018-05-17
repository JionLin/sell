package com.jiaolin.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:59 2018/5/4
 * @Modify By:
 */
@Data
@Component
@ConfigurationProperties(prefix ="projecturl")
public class ProjectUrlConfig {
//	微信公众平台授权账号
	private String wechatMpAuthorize;
}
