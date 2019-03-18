package com.springcloud.client.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@FeignClient(value = "eureka-service-a")
public interface ServiceARemoteAPI {

    @RequestMapping("/feignInvoke/servicea")
    String feignInvokeServiceA();


}
