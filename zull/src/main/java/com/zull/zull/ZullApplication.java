package com.zull.zull;

import com.zull.zull.filter.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZullApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZullApplication.class, args);
    }

    @Bean
    public LoginFilter firstPreFilter(){
        return new LoginFilter();
    }


}
