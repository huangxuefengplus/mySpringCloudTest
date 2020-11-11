package com.hxf.springcloud.dao;
import com.hxf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 信息技术部_黄学峰
 * @date 2020/10/31 10:37
 */
@Mapper
public interface PaymentDao {
    public int  create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
