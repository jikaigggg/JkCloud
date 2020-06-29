package com.jikaigg.jkcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
前后端传递参数的json实体类
 */
public class CommonResult<T> {
    //404 NOT FOUND
    //返回码code
    private Integer code;
    //返回的消息体
    private String message;

    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }


}
