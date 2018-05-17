package com.jiaolin.sell.controller;

import com.jiaolin.sell.dto.OrderDTO;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.service.OrderService;
import com.jiaolin.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 14:40 2018/5/7
 * @Modify By:
 */
@Controller
@Slf4j
@RequestMapping("/pay")
public class PayController {
	//支付订单

	@Autowired
	private OrderService orderService;

	@Autowired
	private PayService payService;

	@PostMapping("/create")
	public ModelAndView create(@RequestParam("orderId") String orderId,
							   @RequestParam("returnUrl") String returnUrl,
							   Map<String, Object> map) {

		//进行订单的查询
		OrderDTO orderDTO = orderService.findByOrderId(orderId);
		if (orderDTO == null) {
			log.error("订单不存在");
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
		PayResponse payResponse = payService.create(orderDTO);

		map.put("payResponse", payResponse);
		map.put("returnUrl", returnUrl);

		return new ModelAndView("pay/create", map);
	}

	//微信异步通知/notify
	// RequestBody该注解用于读取Request请求的body部分数据,然后把相应的数据绑定到要返回的对象上
	//在把返回的对象数据绑定到 controller中方法的参数上。
	@PostMapping("/notify")
	public ModelAndView notify(@RequestBody String notify) {
		payService.notify(notify);
		return new ModelAndView("pay/success");
	}
}
