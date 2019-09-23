package com.zlx.reverce.controller;


import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.common.ListResp;
import com.zlx.reverce.entity.TAddressRoomInfo;
import com.zlx.reverce.service.ITAddressRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/address-room-info")
public class TAddressRoomInfoController {

    @Autowired
    ITAddressRoomInfoService itAddressRoomInfoService;

    @PostMapping("/insert")
    Object insert(TAddressRoomInfo tAddressRoomInfo) {
        boolean save = itAddressRoomInfoService.save(tAddressRoomInfo);
        return ReturnUtil.returnMap(save);
    }

    @PostMapping("/select")
    Object select() {
        return ReturnUtil.returnSuccess(new ListResp<>(itAddressRoomInfoService.list()));
    }

}
