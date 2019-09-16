package com.zlx.reverce.controller;


import com.alibaba.fastjson.JSON;
import com.zlx.reverce.constant.ResponseCode;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.ListResp;
import com.zlx.reverce.entity.TOrder;
import com.zlx.reverce.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/order")
public class TOrderController {

    @Autowired
    ITOrderService itOrderService;

    @PostMapping("/insertOrder")
    Object insertOrder(String reservePhone, String address, String joinNumber, String reserveType, String budget,
                       Long startDate, Long endDate) {
        TOrder tOrder = new TOrder();
        tOrder.setReservePhone(reservePhone);
        tOrder.setAddress(address);
        tOrder.setJoinNumber(joinNumber);
        tOrder.setReserveType(reserveType);
        tOrder.setBudget(budget);
        tOrder.setStartDate(new Date(startDate));
        tOrder.setEndDate(new Date(endDate));
        System.out.println(JSON.toJSONString(tOrder));
        boolean save = itOrderService.save(tOrder);
        return ReturnUtil.returnSuccess(save ? ResponseCode.success : ResponseCode.failed);
    }

    @PostMapping("/selectAll")
    Object selectAll() {
        return ReturnUtil.returnSuccess(ResponseCode.success, new ListResp<TOrder>(itOrderService.list()));
    }

    @PostMapping("/deleteOrderById")
    Object deleteOrderById(String orderId) {
        boolean b = itOrderService.removeById(orderId);
        return ReturnUtil.returnSuccess(b ? ResponseCode.success : ResponseCode.failed);

    }
}
