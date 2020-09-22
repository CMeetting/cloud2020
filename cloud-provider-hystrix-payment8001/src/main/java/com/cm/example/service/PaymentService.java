package com.cm.example.service;

import com.cm.example.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    String paymentInfo_OK(Long id);

    String paymentInfo_Timeout(Long id);

    String paymentCircuitBreaker(Long id);
}
