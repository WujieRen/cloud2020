package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author rwj
 * @create_time 2021/4/15
 */
public interface PaymentService {
    Payment getPaymentById(@Param("id") Long id);
}
