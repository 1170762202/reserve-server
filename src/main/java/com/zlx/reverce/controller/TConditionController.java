package com.zlx.reverce.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlx.reverce.constant.ResponseCode;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.entity.TCondition;
import com.zlx.reverce.entity.TUser;
import com.zlx.reverce.service.ITConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-17
 */
@Controller
@RequestMapping("/condition")
public class TConditionController {

    @Autowired
    ITConditionService itConditionService;


    @PostMapping("/saveCondition")
    Object saveCondition(TCondition tCondition) {
        boolean save = itConditionService.save(tCondition);
        return ReturnUtil.returnSuccess(save ? ResponseCode.success : ResponseCode.failed);
    }

    @PostMapping("/getCondition")
    Object getCondition() {
        QueryWrapper<TCondition> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("type");
        return ReturnUtil.returnSuccess(ResponseCode.success, itConditionService.list(queryWrapper));
    }

    @PostMapping("/deleteCondition")
    Object deleteCondition(String conditionId) {
        boolean b = itConditionService.removeById(conditionId);
        return ReturnUtil.returnMap(b);
    }
}
