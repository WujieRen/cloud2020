package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rwj
 * @create_time 2021/4/15
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
