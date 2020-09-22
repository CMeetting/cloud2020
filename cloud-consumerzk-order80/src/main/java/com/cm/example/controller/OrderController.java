package com.cm.example.controller;

import com.cm.example.entities.CommonResult;
import com.cm.example.entities.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/8 13:56
 * @Version:1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/zk")
    public String getzk(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk/",String.class);
    }
}
