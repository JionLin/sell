package com.jiaolin.sell.service;

import com.jiaolin.sell.dto.OrderDTO;

/**
 * @Auther: Joinlin
 * @Descriptional: 推送消息
 * @Date: Create in 16:29 2018/5/21
 * @Modify By:
 */
public interface PushMessageService {

	/**
	 * 订单状态变更消息
	 * @param orderDTO
	 */
	void OrderStatus(OrderDTO orderDTO);
}
