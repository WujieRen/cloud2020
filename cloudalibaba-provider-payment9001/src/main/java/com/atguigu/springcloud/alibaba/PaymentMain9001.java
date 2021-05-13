package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author rwj
 * @create_time 2021/5/13
 * @description 基于nacos的服务提供者
 *      pom添加依赖，配置appication.yml中的而参数，主启动类添加 @EnableDiscoveryClient
 *      只需要下载nacos，解压启动$NACOS_HOME/bin/startup.cmd/sh 即可
 *      localhost:8848/nacos -》 serviceManagement -》 service list 即可查看到服务已注册
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class, args);
    }
}
