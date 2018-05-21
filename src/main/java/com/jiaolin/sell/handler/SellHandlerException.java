package com.jiaolin.sell.handler;

import com.jiaolin.sell.config.ProjectUrlConfig;
import com.jiaolin.sell.exception.SellAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: Joinlin
 * @Descriptional: 全局异常处理器
 * @Date: Create in 11:35 2018/5/21
 * @Modify By:
 */
@ControllerAdvice
public class SellHandlerException {

	@Autowired
	private ProjectUrlConfig projectUrlConfig;

	@ExceptionHandler(value = SellAuthorizeException.class)
	public ModelAndView handlerException() {
//		return new ModelAndView("redirect:"
//				.concat(projectUrlConfig.getSell())
//				.concat("/sell/seller/order/list"));
		return new ModelAndView("redirect:".concat("https://www.baidu.com"));
	}
}
