package com.springcloud.client.controller;

import model.DataModel;
import model.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
