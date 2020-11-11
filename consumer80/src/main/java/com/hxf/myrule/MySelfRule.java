package com.hxf.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/11/4 21:52
 */
@Configuration
public class MySelfRule {
     @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
