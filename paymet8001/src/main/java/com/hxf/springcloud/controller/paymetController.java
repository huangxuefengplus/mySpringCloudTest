package com.hxf.springcloud.controller;


import com.hxf.springcloud.entities.CommonReault;
import com.hxf.springcloud.entities.Payment;
import com.hxf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/10/31 12:03
 */
@RestController
@Slf4j
public class paymetController {
     @Resource
      private PaymentService paymentService;
     @Value("${server.port}")
      private String serverPort;
     @Resource
     private DiscoveryClient discoveryClient;

       @PostMapping(value="/payment/create")
      public CommonReault create(Payment payment) {

          int result=paymentService.create(payment);
           log.info("插入结果"+result);
           if(result>0){
               return new CommonReault(200,"插入数据库成功,serverPort: "+serverPort,result);
           }else{
               return new CommonReault(444,"");

           }
      }
      @GetMapping(value="/payment/get/{id}")
    public CommonReault getPaymentByid(@PathVariable("id") Long id) {

          Payment payment=paymentService.getPaymentByid(id);
        log.info("插入结果"+payment);
        if(payment!=null){
            return new  CommonReault(200,"查询成功"+serverPort,payment);
        }else{
            return new  CommonReault(444,"无记录","");

        }
    }
    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: "+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }
}
