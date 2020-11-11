package com.hxf.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/10/31 10:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonReault<T> {
    private  Integer code;
    private String message;
    private T data;

    public CommonReault(Integer code, String message) {
        this(code,message,null);
    }
}
