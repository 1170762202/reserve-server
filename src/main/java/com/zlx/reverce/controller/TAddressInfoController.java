package com.zlx.reverce.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.ListResp;
import com.zlx.reverce.entity.TAddressInfo;
import com.zlx.reverce.entity.TAddressRoomInfo;
import com.zlx.reverce.entity.TUser;
import com.zlx.reverce.service.ITAddressInfoService;
import com.zlx.reverce.service.ITAddressRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/address_info")
public class TAddressInfoController {

    @Autowired
    ITAddressInfoService itAddressInfoService;


    @PostMapping("/insert")
    Object insert(TAddressInfo tAddressInfo) {
        boolean save = itAddressInfoService.save(tAddressInfo);
        return ReturnUtil.returnMap(save);
    }

    @PostMapping("/select")
    Object select() {
        return ReturnUtil.returnSuccess(new ListResp<>(itAddressInfoService.list()));
    }


}
