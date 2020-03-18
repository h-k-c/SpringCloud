package com.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author 胡开成
 * @Date 2020/3/19 3:42
 */
@RestController
public class OrderController {

    public static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consul/zk")
    public String payment(){
        String res=restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return res;
    }
}
