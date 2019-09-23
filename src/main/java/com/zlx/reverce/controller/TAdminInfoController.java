package com.zlx.reverce.controller;


import com.zlx.reverce.annotation.UserLoginToken;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.entity.TAdminInfo;
import com.zlx.reverce.service.ITAdminInfoService;
import com.zlx.reverce.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-23
 */
@RestController
@RequestMapping("/t-admin-info")
public class TAdminInfoController {

    @Autowired
    ITAdminInfoService itAdminInfoService;


    @PostMapping("/getAdminInfo")
    Object getAdminInfo() {
        return ReturnUtil.returnSuccess(itAdminInfoService.list());
    }

    @PostMapping("/alterAdminMobile")
    @UserLoginToken
    Object alterAdminMobile(TAdminInfo tAdminInfo) {
        if (!ValidatorUtil.isMobile(tAdminInfo.getAdminMobile())) {
            return ReturnUtil.returnFail("手机号错误");
        }
        boolean b = itAdminInfoService.saveOrUpdate(tAdminInfo);
        return ReturnUtil.returnMap(b);
    }
}
