package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author rwj
 * @create_time 2021/5/13
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain93 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain93.class, args);
    }
}
