package com.cm.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/24 14:42
 * @Version:1.0
 */
@RestController
@RefreshScope
@RequestMapping("/config")
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
