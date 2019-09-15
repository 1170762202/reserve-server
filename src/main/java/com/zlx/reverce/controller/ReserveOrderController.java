package com.zlx.reverce.controller;

import com.alibaba.fastjson.JSON;
import com.zlx.reverce.constant.ResponseCode;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.ListResp;
import com.zlx.reverce.domain.ReserveOrder;
import com.zlx.reverce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ReserveOrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/insertOrder")
    Object insertOrder(ReserveOrder order) {
        System.out.println(JSON.toJSONString(order));
        orderService.insertOrder(order);
        return ReturnUtil.returnSuccess(ResponseCode.success);
    }

    @PostMapping("/selectAll")
    Object selectAll() {
       return ReturnUtil.returnSuccess(ResponseCode.success,new ListResp(orderService.selectAll()));
    }
}
