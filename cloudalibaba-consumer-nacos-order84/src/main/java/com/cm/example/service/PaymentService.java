package com.cm.example.service;

import com.cm.example.entities.CommonResult;
import com.cm.example.service.fallbak.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-nacos-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id);
}
