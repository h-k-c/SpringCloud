package com.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author 胡开成
 * @Date 2020/3/19 2:47
 */
@RestController
public class OrderController {

    private static final String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String payment(){
        String res=restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return res;
    }
}
