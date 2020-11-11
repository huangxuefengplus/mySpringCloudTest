package com.hxf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/11/5 21:43
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumeFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeFeignMain80.class,args);
    }
}
