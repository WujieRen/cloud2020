package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rwj
 * @create_time 2021/5/13
 * @description
 */
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registry, serverPort: "+ serverPort+"<---------->id:"+id;
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        if(payment != null) {
            return new CommonResult(200, "查询成功!ServerPort：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询失败!查询id："+id, null);
        }
    }
}
