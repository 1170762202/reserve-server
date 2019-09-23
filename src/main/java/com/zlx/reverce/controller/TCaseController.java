package com.zlx.reverce.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.common.ListResp;
import com.zlx.reverce.entity.TCase;
import com.zlx.reverce.entity.TCaseInfo;
import com.zlx.reverce.service.ITCaseInfoService;
import com.zlx.reverce.service.ITCaseService;
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
@RequestMapping("/t_case/t-case")
public class TCaseController {

    @Autowired
    ITCaseService itCaseService;

    @Autowired
    ITCaseInfoService itCaseInfoService;


    @PostMapping("/insert")
    Object insert(TCase tCase) {
        boolean save = itCaseService.save(tCase);
        return ReturnUtil.returnMap(save);
    }

    @PostMapping("/select")
    Object select() {
        QueryWrapper<TCase> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        return ReturnUtil.returnSuccess(new ListResp<>(itCaseService.list(queryWrapper)));
    }


    @PostMapping("/deleteById")
    Object deleteById(String id) {
        boolean b = itCaseService.removeById(id);
        QueryWrapper<TCaseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("case_id", id);
        boolean remove = itCaseInfoService.remove(queryWrapper);
        return ReturnUtil.returnMap(b);
    }
}
