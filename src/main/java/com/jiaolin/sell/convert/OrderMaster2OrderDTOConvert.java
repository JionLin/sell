package com.jiaolin.sell.convert;

import com.jiaolin.sell.dataobject.OrderMaster;
import com.jiaolin.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Joinlin
 * @Descriptional: 订单主表转化为订单dto
 * @Date: Create in 9:41 2018/4/27
 * @Modify By:
 */
public class OrderMaster2OrderDTOConvert {
	//订单主表转换为订单dto
	public static OrderDTO convert(OrderMaster orderMaster){
		OrderDTO orderDTO=new OrderDTO();
		BeanUtils.copyProperties(orderMaster,orderDTO);
		return orderDTO;
	}
	//List<OrderMaster>转换为List<OrderDTO>
	public static List<OrderDTO> converList(List<OrderMaster> orderMasterList){
		return orderMasterList.stream().map(e ->convert(e))
				.collect(Collectors.toList());
	}
}
