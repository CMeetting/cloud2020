package com.cm.example.controller;

import com.cm.example.entities.CommonResult;
import com.cm.example.entities.Payment;
import com.cm.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/8 10:33
 * @Version:1.0
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.create(payment);
        if(res>0){
            return new CommonResult(200,"插入成功！serverport:"+serverport);
        }else{
            return new CommonResult(400,"插入失败");
        }
    }


    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(null!=payment){
            return new CommonResult(200,"success,serverport:"+serverport,payment);
        }else{
            return new CommonResult(400,"查询记录不存在");
        }
    }

    @RequestMapping("/zk")
    public String getZk(){
        return "zookeeper:"+serverport;
    }


}
