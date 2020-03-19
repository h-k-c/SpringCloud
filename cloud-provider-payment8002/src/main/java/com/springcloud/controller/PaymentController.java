package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author 胡开成
 * @Date 2020/3/18 13:54
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int res=paymentService.create(payment);
        if(res>0){
            return new CommonResult<Payment>(200,"插入成功,serverPort: "+serverPort,payment);
        }else{
            return new CommonResult<>(440,"插入失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment res=paymentService.getPaymentById(id);
        if(res!=null){
            return new CommonResult<Payment>(200,"查找成功.serverPort: "+serverPort,res);
        }else{
            return new CommonResult<>(440,"查找失败",null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPayments(){
        return serverPort;
    }
}
