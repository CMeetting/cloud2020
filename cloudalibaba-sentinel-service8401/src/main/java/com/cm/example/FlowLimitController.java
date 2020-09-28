package com.cm.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description:
 * @Author:cm
 * @Date:2020/9/27 16:55
 * @Version:1.0
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        System.out.println(new Date()+"   "+System.currentTimeMillis() / 1000);
        return "--------testB";
    }

}
