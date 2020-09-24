package com.cm.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/24 13:58
 * @Version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain83.class,args);
    }
}
