package com.cm.example.service.fallbak;

import com.cm.example.entities.CommonResult;
import com.cm.example.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return new CommonResult(44444,"服务降级："+id);
    }
}
