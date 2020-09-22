package com.cm.example.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cm.example.dao.PaymentDao;
import com.cm.example.entities.Payment;
import com.cm.example.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/8 10:21
 * @Version:1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public String paymentInfo_OK(Long id) {
        return "一切正常OK"+id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Long id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "执行3s"+id;
    }

    //服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期（时间范围）
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//失败率
    })
    public String paymentCircuitBreaker(Long id) {
        if(id<0){
            throw new RuntimeException("id为负数");
        }
        return Thread.currentThread().getName()+"调用成功："+"id"+id+"流水号："+ IdUtil.simpleUUID();
    }

    public String paymentInfo_Timeout_Handler(Long id) {
        return "服务降级"+id;
    }

    public String paymentCircuitBreaker_fallback(Long id) {
        return "熔断降级id不能为负数"+id;
    }
}
