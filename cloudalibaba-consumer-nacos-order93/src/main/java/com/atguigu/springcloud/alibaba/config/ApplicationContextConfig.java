package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author rwj
 * @create_time 2021/5/13
 * @description
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 这里不加@LoanBalanced会报错：java.net.UnknownHostException: nacos-payment-provider
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
