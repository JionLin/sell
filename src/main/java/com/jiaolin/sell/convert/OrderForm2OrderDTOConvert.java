package com.jiaolin.sell.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiaolin.sell.dataobject.OrderDetail;
import com.jiaolin.sell.dto.OrderDTO;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.form.OrderForm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.Control;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class OrderForm2OrderDTOConvert {
	/**
	 * 把orderForm订单表格转换成orderDTO
	 *
	 * @param orderForm
	 * @return
	 */
	public static OrderDTO convert(OrderForm orderForm) {
		Gson gson = new Gson();
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());
		orderDTO.setBuyerPhone(orderForm.getPhone());

		//把json格式转换成list
		Type type = new TypeToken<List<OrderDetail>>() {
		}.getType();
		List<OrderDetail> orderDetailList = new ArrayList<>();
		try {
			orderDetailList =gson.fromJson(orderForm.getItems(),type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
	}

}
