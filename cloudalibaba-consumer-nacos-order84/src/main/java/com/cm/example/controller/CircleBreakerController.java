package com.cm.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cm.example.entities.CommonResult;
import com.cm.example.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL="http://cloud-nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

//    @GetMapping("/order/get/{id}")
//    @SentinelResource(value = "fallback",fallback = "fallback")//只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//只负责sentinel控制台违规
//    @SentinelResource(value = "fallback", fallback = "fallback", blockHandler = "blockHandler",
//            exceptionsToIgnore = {IllegalArgumentException.class})
//    public CommonResult getPaymentById(@PathVariable("id")Long id){
//        CommonResult result = restTemplate.getForObject(SERVICE_URL+"/payment/get/"+id,CommonResult.class);
//        if(id==4){
//            throw new IllegalArgumentException("非法参数异常");
//        }
//        return result;
//    }

//    public CommonResult fallback(@PathVariable("id")Long id,Throwable e){
//        return new CommonResult(444,"异常处理:"+e.getMessage()+"id:"+id);
//    }
//
//    public CommonResult blockHandler(@PathVariable("id")Long id, BlockException e){
//        return new CommonResult(445,"异常处理block:"+e.getMessage()+"id:"+id);
//    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        return paymentService.getPaymentById(id);
    }

}
