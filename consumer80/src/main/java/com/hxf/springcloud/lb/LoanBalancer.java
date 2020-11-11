package com.hxf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/11/4 22:27
 */
public interface LoanBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
