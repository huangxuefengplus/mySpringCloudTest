package com.hxf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/11/1 15:48
 */
@SpringBootApplication
@EnableEurekaServer
public class eurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(eurekaMain7001.class,args);
    }

}
