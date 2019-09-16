package com.springcloud.client.controller;

import com.google.gson.JsonArray;
import com.springcloud.client.service.UserService;
import model.DataModel;
import model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2019/8/29 19:04
 * @Description :主页面
 */
@Controller
@RequestMapping("/main")
public class IndexController {

    @Autowired
    private UserService userService;

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
    public JsonResult login(@RequestBody Map<String,String> map) throws NoSuchAlgorithmException {

        String username = map.get("username");
        String password = map.get("password");


        JsonResult jsonResult = userService.login(username,password);

        return jsonResult;
    }

    @RequestMapping(value = "/mainList",method = RequestMethod.POST)
    @ResponseBody
    public  JsonResult mainList(){

        List<DataModel> dataModels = new ArrayList<DataModel>(5);
        DataModel dataModel1 = new DataModel("1","data1");
        DataModel dataModel2 = new DataModel("2","data2");
        DataModel dataModel3 = new DataModel("3","data3");

        dataModels.add(dataModel1);
        dataModels.add(dataModel2);
        dataModels.add(dataModel3);

        return new JsonResult(dataModels);
    }
}
