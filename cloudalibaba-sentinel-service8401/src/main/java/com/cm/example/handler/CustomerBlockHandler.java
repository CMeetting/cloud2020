package com.cm.example.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cm.example.entities.CommonResult;
import com.cm.example.entities.Payment;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/29 16:35
 * @Version:1.0
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"自定义测试访问block");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"自定义测试访问block2");
    }
}
