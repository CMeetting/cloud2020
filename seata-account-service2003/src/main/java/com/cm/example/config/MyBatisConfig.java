package com.cm.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.cm.example.dao"})
public class MyBatisConfig {
}
