package com.cm.example.service.impl;

import com.cm.example.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "服务降级通配OK";
    }

    @Override
    public String paymentInfo_Timeout(Long id) {
        return "服务降级通配TO";
    }
}
