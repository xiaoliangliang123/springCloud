package com.springcloud.client.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "eureka-service-b" ,url="localhost:9003")
public interface ServiceBRemoteAPI {

    @RequestMapping("/invoke")
    String feignInvokeServiceB();

    @RequestMapping("/invokeAdd")
    Integer invokeAdd(@RequestParam("a") final int a, @RequestParam("b")  final int b);

}
