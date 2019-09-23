package com.zlx.reverce.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlx.reverce.constant.ResponseCode;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.common.ListResp;
import com.zlx.reverce.entity.TAdminInfo;
import com.zlx.reverce.entity.TOrder;
import com.zlx.reverce.entity.TSundryInfo;
import com.zlx.reverce.service.ITAdminInfoService;
import com.zlx.reverce.service.ITOrderService;
import com.zlx.reverce.service.ITSundryInfoService;
import com.zlx.reverce.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

    @Autowired
    ITSundryInfoService itSundryInfoService;

    @Autowired
    ITAdminInfoService itAdminInfoService;


    @PostMapping("/insertOrder")
    Object insertOrder(String reservePhone, String address, String joinNumber, String reserveType, String budget,
                       Long startDate, Long endDate, String mobileCode) {
        QueryWrapper<TSundryInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", reservePhone);
        queryWrapper.eq("mobile_code", mobileCode);
        TSundryInfo one = itSundryInfoService.getOne(queryWrapper);
        if (one == null) {
            return ReturnUtil.returnFail("请获取验证码");
        }
        Date createTime = one.getCreateTime();
        long between = (new Date().getTime() - createTime.getTime()) / 1000;//秒
        if (between > 5 * 60 * 1000) {
            return ReturnUtil.returnFail("验证码已过时，请重新获取");
        }

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
        if (save) {
            List<TAdminInfo> list = itAdminInfoService.list();
            if (list.size() > 0) {
                TAdminInfo tAdminInfo = list.get(0);
                String adminMobile = tAdminInfo.getAdminMobile();
                SmsUtil.sendNotify(adminMobile, reservePhone);
            }
        }
        return ReturnUtil.returnSuccess(save ? ResponseCode.success : ResponseCode.failed);
    }

    @PostMapping("/selectAll")
    Object selectAll() {
        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        return ReturnUtil.returnSuccess(ResponseCode.success,
                new ListResp<TOrder>(itOrderService.list(queryWrapper)));
    }

    @PostMapping("/deleteOrderById")
    Object deleteOrderById(String orderId) {
        System.out.println("deleteOrderById:" + orderId);
        boolean b = itOrderService.removeById(orderId);
        return ReturnUtil.returnSuccess(b ? ResponseCode.success : ResponseCode.failed);

    }
}
