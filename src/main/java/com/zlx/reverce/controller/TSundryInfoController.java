package com.zlx.reverce.controller;


import com.alibaba.fastjson.JSON;
import com.zlx.reverce.constant.ResponseCode;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.entity.TSundryInfo;
import com.zlx.reverce.service.ITSundryInfoService;
import com.zlx.reverce.util.SmsUtil;
import com.zlx.reverce.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.Random;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-20
 */
@RestController
@RequestMapping("/t_sundry_info/t-sundry-info")
public class TSundryInfoController {

    @Autowired
    ITSundryInfoService itSundryInfoService;

    @PostMapping("/getMobileCode")
    Object getMobileCode(String mobile) {
        System.out.println("getMobileCode:"+mobile);
        boolean mobile1 = ValidatorUtil.isMobile(mobile);
        if (!mobile1) {
            return ReturnUtil.returnFail("请输入正确的手机号");
        }
        String code = SmsUtil.sendSms(mobile);
        TSundryInfo tSundryInfo = new TSundryInfo();
        tSundryInfo.setMobile(mobile);
        tSundryInfo.setMobileCode(code);
        boolean save = itSundryInfoService.save(tSundryInfo);
        return ReturnUtil.returnMap(true);
    }

}
