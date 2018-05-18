package com.jiaolin.sell.controller;

import com.jiaolin.sell.config.ProjectUrlConfig;
import com.jiaolin.sell.constant.CookieConstant;
import com.jiaolin.sell.constant.RedisConstant;
import com.jiaolin.sell.dataobject.SellerInfo;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.service.SellService;
import com.jiaolin.sell.utils.CookUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

	@Autowired
	private ProjectUrlConfig projectUrlConfig;

	@GetMapping("/login")
	public ModelAndView login(String openid,
							  Map<String, Object> map,
							  HttpServletResponse response) {
		SellerInfo sellerInfo = sellService.findByopenid(openid);
		//1 openid去和数据库匹配
		if (sellerInfo == null) {
			map.put("msg", ResultEnum.SELL_USER_ERROR);
			map.put("url", "/sell/seller/order/list");
			return new ModelAndView("common/error", map);
		}

		//2把token设置到redis
		String token = UUID.randomUUID().toString();
		redisTemplate.opsForValue().set(String.format(RedisConstant.REDIS_PRIFIX, token),
				openid, RedisConstant.EXPIRE,
				TimeUnit.SECONDS);
		//3把token设置到cookie中
		CookUtils.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
		return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,
							   HttpServletResponse response,
							   Map<String, Object> map) {
		//从cookie中查询
		Cookie cookie = CookUtils.get(request, CookieConstant.TOKEN);
		if (cookie != null) {
			//从redis中删除token
			redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.REDIS_PRIFIX, cookie.getValue()));
			//从cookie中删除 token
			CookUtils.set(response, CookieConstant.TOKEN, null, 0);
		}
		map.put("msg", ResultEnum.SELL_USER_SUCCESS.getMessage());
		map.put("url", "/sell/seller/order/list");
		return new ModelAndView("common/success", map);
	}

}
