package com.zlx.reverce.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.service.additional.AbstractChainWrapper;
import com.zlx.reverce.annotation.LimitKey;
import com.zlx.reverce.annotation.SecretAnnotation;
import com.zlx.reverce.annotation.UserLoginToken;
import com.zlx.reverce.constant.ResponseCode;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.StringResp;
import com.zlx.reverce.entity.TUser;
import com.zlx.reverce.entity.TUserInfo;
import com.zlx.reverce.service.ITUserInfoService;
import com.zlx.reverce.service.ITUserService;
import com.zlx.reverce.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/user")
public class TUserController {

    @Autowired
    ITUserService itUserService;

    @Autowired
    TokenService tokenService;

    @Autowired
    ITUserInfoService itUserInfoService;

    @PostMapping(value = "/login")
//    @SecretAnnotation(encode = true, decode = true)
    Object login(TUser user) {
        System.out.println("login:" + JSON.toJSONString(user));
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", user.getAccount())
                .eq("password", user.getPassword());
        TUser tUser = itUserService.getOne(queryWrapper);
        if (tUser == null) {
            return ReturnUtil.returnFail(null);
        }
        String token = tokenService.getToken(tUser);
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setUserId(tUser.getId());
        tUserInfo.setUserToken(token);
        itUserInfoService.saveOrUpdate(tUserInfo);
        return ReturnUtil.returnSuccess(ResponseCode.success, new StringResp(token));
    }


    @UserLoginToken
    @PostMapping("/test")
    public String test1() {
        return "通过验证";
    }

    @PostMapping("/save")
    @LimitKey(frequency = 3, methodName = "save", paramKey = "saveUser", timeout = 5, url = "/user/save")
    public Map save(TUser tUser) {
        if (tUser == null) {
            return ReturnUtil.returnSuccess(ResponseCode.failed);
        }
        boolean save = itUserService.save(tUser);
        return ReturnUtil.returnSuccess(save ? ResponseCode.success : ResponseCode.failed);
    }

}
