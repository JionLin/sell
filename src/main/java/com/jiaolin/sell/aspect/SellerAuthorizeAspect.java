package com.jiaolin.sell.aspect;

import com.jiaolin.sell.constant.CookieConstant;
import com.jiaolin.sell.exception.SellAuthorizeException;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.utils.CookUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:48 2018/5/18
 * @Modify By:
 */
@Component
@Aspect
@Slf4j
public class SellerAuthorizeAspect {

	@Pointcut("execution(public * com.jiaolin.sell.controller.sell*.*(..))" +
			"&& !execution(public * com.jiaolin.sell.controller.SellUserController.*(..))")
	public void verify() {
	}

	;

	@Before("verify()")
	public void doVerify() {
		//RequestContextHolder 获取上下文的容器
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = attributes.getRequest();
		//进行cookie的查询
		Cookie cookie = CookUtils.get(request, CookieConstant.TOKEN);
		if (cookie == null) {
			log.info("[登录校验]登录中cookie不存在");
			throw new SellAuthorizeException();
		}


		//进行redis的查询

	}
}
