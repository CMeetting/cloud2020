package com.cm.example;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cm.example.entities.CommonResult;
import com.cm.example.entities.Payment;
import com.cm.example.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/29 15:53
 * @Version:1.0
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试访问",new Payment(2020L,"000001"));
    }

    public CommonResult handleException(BlockException blockException){
        return new CommonResult(444,"服务不可用"+blockException.getClass().getCanonicalName());
    }

    @GetMapping("/customerHandler")
    @SentinelResource(value = "customerHandler",blockHandlerClass = CustomerBlockHandler.class,
    blockHandler = "handlerException2")
    public CommonResult customerHandler(){
        return new CommonResult(200,"自定义测试访问",new Payment(2020L,"000001"));
    }
}
