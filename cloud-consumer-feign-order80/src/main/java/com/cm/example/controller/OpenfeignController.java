package com.cm.example.controller;

import com.cm.example.entities.CommonResult;
import com.cm.example.service.OpenfeignOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/openfeign")
public class OpenfeignController {

    @Resource
    private OpenfeignOrderService openfeignOrderService;

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return openfeignOrderService.getPaymentById(id);
    }

    @GetMapping("/timeout")
    public String getTimeout(){
        return openfeignOrderService.getTimeout();
    }
}
