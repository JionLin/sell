package com.jiaolin.sell.service;

import com.jiaolin.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 16:42 2018/5/7
 * @Modify By:
 */
public interface PayService {
	PayResponse create(OrderDTO orderDTO);

	PayResponse notify(String notifyData);

	RefundResponse refund(OrderDTO orderDTO);
}
