package com.atguigu.springcloud.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author rwj
 * @create_time 2021/5/12
 * @description
 */
//@Configuration
//public class ConfigBean {
//
//    ///默认实现了轮询算法
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    //自己实现负载均衡策略
////    @Bean
////    public IRule myRule() {
////        return new RandomRule();
////    }
//}
