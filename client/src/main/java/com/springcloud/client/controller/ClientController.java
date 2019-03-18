package com.springcloud.client.controller;

import com.springcloud.client.service.ServiceARemoteAPI;
import com.springcloud.client.service.ServiceBRemoteAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
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


    @RequestMapping("/ribbonInvoke/servicea")
    @ResponseBody
    public String ribbonInvokeServiceA(){

        String result = restTemplate.getForEntity(serviceaId+"/invoke", String.class).getBody();
        return result;
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

}
