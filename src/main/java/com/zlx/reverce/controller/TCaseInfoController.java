package com.zlx.reverce.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.CaseResp;
import com.zlx.reverce.constant.response.common.ListResp;
import com.zlx.reverce.entity.TCase;
import com.zlx.reverce.entity.TCaseInfo;
import com.zlx.reverce.service.ITCaseInfoService;
import com.zlx.reverce.service.ITCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/t_case_info/t-case-info")
public class TCaseInfoController {

    @Autowired
    ITCaseService itCaseService;

    @Autowired
    ITCaseInfoService itCaseInfoService;

    @PostMapping("/insert")
    Object insert(TCaseInfo tCase) {
        boolean save = itCaseInfoService.save(tCase);
        return ReturnUtil.returnMap(save);
    }

    @PostMapping("/select")
    Object select() {
        List<CaseResp> respList = new ArrayList<>();
        List<TCase> list = itCaseService.list();
        for (TCase tCase : list) {
            String id = tCase.getId();
            QueryWrapper<TCaseInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("case_id", id);
            List<TCaseInfo> list1 = itCaseInfoService.list(queryWrapper);
            CaseResp caseResp = new CaseResp();
            caseResp.setCaseId(id);
            caseResp.setCaseName(tCase.getCaseName());
            caseResp.setCaseInfoList(list1);
            respList.add(caseResp);
        }
        return ReturnUtil.returnSuccess(respList);
    }
}
