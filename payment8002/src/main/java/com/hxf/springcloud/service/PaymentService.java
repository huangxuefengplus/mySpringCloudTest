package com.hxf.springcloud.service;

import com.hxf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/10/31 11:04
 */
public interface PaymentService {
    public int  create(Payment payment);
    public Payment getPaymentByid(@Param("id") Long id);
}
