package com.cm.example.controller;

import com.cm.example.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "paymentInfo_Global_Handler")//此方法并不能传递参数
@RequestMapping("order/hystrix")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/to/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Long id){
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

    public String paymentInfo_Timeout_Handler(@PathVariable("id") Long id) {
        return "服务降级80"+id;
    }

    public String paymentInfo_Global_Handler() {
        return "全局降级80";
    }
}
