package com.hxf.springcloud.controller;
import com.hxf.springcloud.entities.CommonReault;
import com.hxf.springcloud.entities.Payment;
import com.hxf.springcloud.lb.LoanBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/10/31 13:23
 */
@RestController
@Slf4j
public class consumerController {
    //public static final String PAYMENT_URL ="http://localhost:8001";
    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private LoanBalancer loanBalancer;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    //返回对象为响应体中数据转化成的对象，基本上可以理解为Json
    @GetMapping("/consumer/payment/create")
    public CommonReault<Payment> create(Payment payment){
      return   restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonReault.class);
    }
  //返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
    @GetMapping("/consumer/payment/get/{id}")
    public CommonReault<Payment> getPayment(@PathVariable("id") Long id){
        return   restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonReault.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonReault<Payment> getPayment2(@PathVariable("id") Long id)
    {
        ResponseEntity<CommonReault> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonReault.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonReault<>(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payments/{id}")
    public  String getPayMentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance serviceInstance = loanBalancer.instance(instances);
       URI uri= serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
