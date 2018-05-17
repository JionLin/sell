package com.jiaolin.sell.controller;

import com.jiaolin.sell.Vo.ResultVo;
import com.jiaolin.sell.convert.OrderForm2OrderDTOConvert;
import com.jiaolin.sell.dto.OrderDTO;
import com.jiaolin.sell.enums.ResultEnum;
import com.jiaolin.sell.exception.SellException;
import com.jiaolin.sell.form.OrderForm;
import com.jiaolin.sell.service.BuyService;
import com.jiaolin.sell.service.OrderService;
import com.jiaolin.sell.utils.ResultVoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyOrderController {
    @Autowired
    private BuyService buyService;
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        //表单验证,
        if (bindingResult.hasErrors()) {
            log.error("[表单参数错误],");
            throw new SellException(ResultEnum.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("订单详情不存在,result={}", orderDTO.getOrderDetailList());
            throw new SellException(ResultEnum.ORDER_DETAIL_EXIST);
        }
        //创建订单
        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVoUtils.success(map);
    }


    /**
     * 购买商品的详情
     *
     * @param openid openid号
     * @param page   多少页
     * @param size   一页显示的行数
     * @return
     */
    @GetMapping("/list")
    public ResultVo list(@RequestParam(value = "openid") String openid,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("openid传入为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);

        return ResultVoUtils.success(orderDTOPage.getContent());
    }


    @GetMapping("/detail")
    public ResultVo<OrderDTO> orderDetail(@RequestParam("openid") String openid,
                                          @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyService.findOrderOne(openid, orderId);
        return ResultVoUtils.success(orderDTO);
    }

    @PostMapping("/cancel")
    public ResultVo cancelOrder(@RequestParam("openid") String openid,
                                @RequestParam("orderId") String orderId) {
        buyService.cancle(openid, orderId);
        return ResultVoUtils.success();
    }
}
