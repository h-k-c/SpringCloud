package com.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 胡开成
 * @Date 2020/3/19 2:42
 */
@Configuration
public class AppicationContextConfig {
    /*
    * @Author hkc
    * @Date 2:44 2020/3/19
    * @info @LoadBalanced用于负载均衡
    **/


    @Bean
    @LoadBalanced
    public RestTemplate getRestTempate(){
        return new RestTemplate();
    }
}
