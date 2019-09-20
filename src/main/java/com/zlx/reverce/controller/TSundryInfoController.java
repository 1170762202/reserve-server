package com.zlx.reverce.controller;


import com.zlx.reverce.service.ITSundryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlx
 * @since 2019-09-20
 */
@Controller
@RequestMapping("/t_sundry_info/t-sundry-info")
public class TSundryInfoController {

    @Autowired
    ITSundryInfoService itSundryInfoService;

    @PostMapping("/getMobileCode")
    Object getMobileCode(){
        return null;
    }

}
