package com.jiaolin.sell.controller;

import com.jiaolin.sell.dataobject.SellInfo;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.service.SellService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:55 2018/5/17
 * @Modify By:
 */
@Controller
@RequestMapping("/seller")
@Slf4j
public class SellUserController {

	@Autowired
	private SellService sellService;

	@Autowired
	private StringRedisTemplate redisTemplate;

	@GetMapping("/login")
	public ModelAndView login(String openid, Map<String, Object> map) {
		SellInfo sellInfo = sellService.findByopenid(openid);
		//1 openid去和数据库匹配
		if (sellInfo == null) {
			map.put("msg", ResultEnum.SELL_USER_ERROR);
			map.put("url", "/sell/seller/order/list");
			return new ModelAndView("common/error", map);
		}

		//2把cookie设置到redis


		//3把cookie设置到token里面
		return new ModelAndView("");
	}

	@GetMapping("/logout")
	public ModelAndView logout() {

		return new ModelAndView("");
	}

}
