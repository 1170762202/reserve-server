package com.zlx.reverce.controller;


import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.ListResp;
import com.zlx.reverce.entity.TAddressInfo;
import com.zlx.reverce.entity.TCase;
import com.zlx.reverce.service.ITCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/t_case/t-case")
public class TCaseController {

    @Autowired
    ITCaseService itCaseService;

    @PostMapping("/insert")
    Object insert(TCase tCase) {
        boolean save = itCaseService.save(tCase);
        return ReturnUtil.returnMap(save);
    }

    @PostMapping("/select")
    Object select() {
        return ReturnUtil.returnSuccess(new ListResp<>(itCaseService.list()));
    }


}
