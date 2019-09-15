package com.zlx.reverce.controller;

import com.alibaba.fastjson.JSON;
import com.zlx.reverce.annotation.LimitKey;
import com.zlx.reverce.annotation.UserLoginToken;
import com.zlx.reverce.config.HostConfig;
import com.zlx.reverce.constant.ResponseCode;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.ListResp;
import com.zlx.reverce.constant.response.StringResp;
import com.zlx.reverce.domain.User;
import com.zlx.reverce.service.TokenService;
import com.zlx.reverce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private HostConfig hostConfig;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    Object login(String account, String password) {
        User user = userService.findUser(account, password);
        System.out.println(JSON.toJSONString(user));
        if (user == null) {
            return ReturnUtil.returnFail(null);
        }
        String token = tokenService.getToken(user);
        return ReturnUtil.returnSuccess(ResponseCode.success, new StringResp(token));
    }

    @UserLoginToken
    @PostMapping("/test")
    public String test1() {
        return "通过验证";
    }

    @PostMapping("/save")
    @LimitKey(frequency = 3, methodName = "save", paramKey = "saveUser", timeout = 5, url = "/user/save")
    public Map save(String name) {
        if (name == null) {
            return ReturnUtil.returnSuccess(ResponseCode.failed);
        }
        return ReturnUtil.returnSuccess(ResponseCode.success);
    }


    @PostMapping("/")
    public void test() {
        System.out.println(hostConfig.getHost() + " " + hostConfig.getPort());
    }

    @PostMapping("/selectAll")
    public Object select() {
        return ReturnUtil.returnSuccess(ResponseCode.success, new ListResp(userService.selectAll()));
    }

    @PostMapping("/insert")
    public Object insert(User user) {
        userService.insert(user);
        return ReturnUtil.returnSuccess(ResponseCode.success);
    }

    @PostMapping("/deleteById")
    public Object deleteById(Long id) {
        userService.deleteUser(id);
        return ReturnUtil.returnSuccess(ResponseCode.success);
    }

    @PostMapping("/updateUserName")
    public Object updateUserName(Long id, String name) {
        int a = 1 / 0;
        userService.updateUserName(id, name);
        return ReturnUtil.returnSuccess(ResponseCode.success);
    }

}
