package com.jiaolin.sell.aspect;

import com.jiaolin.sell.constant.CookieConstant;
import com.jiaolin.sell.constant.RedisConstant;
import com.jiaolin.sell.exception.SellAuthorizeException;
import com.jiaolin.sell.utils.CookUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:48 2018/5/18
 * @Modify By:
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Pointcut("execution(public * com.jiaolin.sell.controller.Sell*.*(..))" +
			"&& !execution(public * com.jiaolin.sell.controller.SellUserController.*(..))")
	public void verify() {
	}


	@Before("verify()")
	public void doVerify() {
		//RequestContextHolder 获取上下文的容器
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = attributes.getRequest();
		//进行cookie的查询
		Cookie cookie = CookUtils.get(request, CookieConstant.TOKEN);
		if (cookie == null) {
			log.warn("[登录校验]登录中cookie不存在token");
			throw new SellAuthorizeException();
		}


		//进行redis的查询
		String reidsValue = redisTemplate.opsForValue().get(String.format(RedisConstant.REDIS_PRIFIX, cookie.getValue()));
		if (StringUtils.isEmpty(reidsValue)) {
			log.warn("[登录校验] 登录中redis差不多token");
			throw new SellAuthorizeException();
		}

	}
}
