package com.springcloud.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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

    @RequestMapping(value = "/loginView",method = RequestMethod.GET)
    public String loginView(){
        return "/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map<String,String> map){


        return "success";
    }
}
