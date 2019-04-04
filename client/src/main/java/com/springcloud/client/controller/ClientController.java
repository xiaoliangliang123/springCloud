package com.springcloud.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.client.service.ServiceARemoteAPI;
import com.springcloud.client.service.ServiceBRemoteAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableHystrix
@RequestMapping("/")
public class ClientController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${servicea.id}")
    String serviceaId;

    @Value("${serviceb.id}")
    String servicebId;

    @Autowired
    ServiceARemoteAPI serviceARemoteAPI;

    @Autowired
    ServiceBRemoteAPI serviceBRemoteAPI;


    @HystrixCommand(fallbackMethod="getFallbackA")
    @RequestMapping("/ribbonInvoke/servicea")
    @ResponseBody
    public String ribbonInvokeServiceA(){

        String result = restTemplate.getForEntity(serviceaId+"/invoke", String.class).getBody();
        return result;
    }


    public Object getFallbackA() {
        return "getFallbackA error";
    }

    @RequestMapping("/ribbonInvoke/serviceb")
    @ResponseBody
    public String ribbonInvokeServiceB(){

        String result = restTemplate.getForEntity(servicebId+"/invoke", String.class).getBody();
        return result;
    }


    @RequestMapping("/feignInvoke/servicea")
    @ResponseBody
    public String feignInvokeServiceA(){

        String result = serviceARemoteAPI.feignInvokeServiceA();
        return result;
    }


    @RequestMapping("/feignInvoke/serviceb")
    @ResponseBody
    public String feignInvokeServiceB(){

        String result = serviceBRemoteAPI.feignInvokeServiceB();
        return result;
    }



    @RequestMapping("/feignInvoke/servicea/add")
    @ResponseBody
    public Integer feignInvokeServiceAAdd(){

        Integer result = serviceARemoteAPI.invokeAdd(1,2);
        return result;
    }


    @RequestMapping("/feignInvoke/serviceb/add")
    @ResponseBody
    public Integer feignInvokeServiceBAdd(){

        Integer result = serviceBRemoteAPI.invokeAdd(5,6);
        return result;
    }

}
