package com.springcloud.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2019/8/29 19:04
 * @Description :主页面
 */
@Controller
@RequestMapping("/main")
public class IndexController {

    @RequestMapping("index")
    public String main(){
        return "/main";
    }
}
