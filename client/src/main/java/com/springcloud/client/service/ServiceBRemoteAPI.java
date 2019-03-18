package com.springcloud.client.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "eureka-service-b")
public interface ServiceBRemoteAPI {

    @RequestMapping("/feignInvoke/serviceb")
    String feignInvokeServiceB();
}
