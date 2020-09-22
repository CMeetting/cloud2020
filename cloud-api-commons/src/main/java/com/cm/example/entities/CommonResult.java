package com.cm.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:统一结果返回
 * @Author:cm
 * @Date:2020/9/8 10:40
 * @Version:1.0
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data =data;
    }

}
