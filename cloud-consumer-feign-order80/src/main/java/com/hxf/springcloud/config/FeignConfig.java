package com.hxf.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 信息技术部_黄学峰
 * @date 2020/11/5 22:28
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL;
    }

}
