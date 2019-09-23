package com.zlx.reverce.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlx.reverce.constant.ReturnUtil;
import com.zlx.reverce.constant.response.common.ListResp;
import com.zlx.reverce.entity.TBanner;
import com.zlx.reverce.service.ITBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-23
 */
@RestController
@RequestMapping("/t-banner")
public class TBannerController {

    @Autowired
    ITBannerService itBannerService;

    @PostMapping("/insertBanner")
    Object insertBanner(TBanner tBanner) {
        return ReturnUtil.returnMap(itBannerService.save(tBanner));
    }

    @PostMapping("/selectBannerByType")
    Object selectBannerByType(String bannerType) {
        QueryWrapper<TBanner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("banner_type", bannerType);
        queryWrapper.orderByAsc("create_time");
        return ReturnUtil.returnSuccess(new ListResp<>(itBannerService.list(queryWrapper)));
    }
}
