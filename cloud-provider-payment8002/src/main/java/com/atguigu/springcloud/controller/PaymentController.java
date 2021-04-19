package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/4/15
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果"+result);
        if(result > 0) {
            return new CommonResult(200, "插入数据库成功!ServerPort：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败!", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
//        log.info("*****查询结果："+payment+"*****");
        log.info("*****查询结果："+payment);
        if(payment != null) {
            return new CommonResult(200, "查询成功! ServerPort：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询失败!查询id："+id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public CommonResult<String> discovery() {
        List<String> services = discoveryClient.getServices();
        StringBuilder serviceInfo = new StringBuilder();
        for(String service : services) {
            serviceInfo.append("serviceName:").append(service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance sInstance : instances) {
                serviceInfo.append(" : ")
                        .append(sInstance.getInstanceId())
                        .append('\n').append('\t')
                        .append(sInstance.getPort())
                        .append(sInstance.getUri());
            }
            serviceInfo.append('\n');
        }
        return new CommonResult<>(200, "服务信息：", serviceInfo.toString());
    }
}
