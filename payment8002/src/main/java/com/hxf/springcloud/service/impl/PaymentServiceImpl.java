package com.hxf.springcloud.service.impl;

import com.hxf.springcloud.dao.PaymentDao;
import com.hxf.springcloud.entities.Payment;
import com.hxf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/10/31 11:05
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int  create(Payment payment){

        return  paymentDao.create(payment);
    };
    @Override
    public Payment getPaymentByid(Long id){
        return  paymentDao.getPaymentById(id);
    };

}
