package com.cm.example.service;

import com.cm.example.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface StorageService {

    void decrease(Long productId, Integer count);
}
