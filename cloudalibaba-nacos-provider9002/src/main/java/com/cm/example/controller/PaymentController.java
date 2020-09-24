package com.cm.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/24 10:20
 * @Version:1.0
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/nacos/{id}")
    public String getPaymentById(@PathVariable("id")Long id){
        return "端口号："+serverport+"id:"+id;
    }
}
