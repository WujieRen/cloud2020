package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rwj
 * @create_time 2021/5/12
 * @description OpenFeign日志打印功能
 *  是什么？
 *      Feign提供了日志打印功能，可以通过配置来调整日志级别，从而了解Feign中Http请求的细节。
 *     说白了就是对接口的调用情况进行监控和输出
 *  日志级别
 *      NONE：默认，不显示任何日志
 *      BASIC：仅记录请求方法、URL、响应状态码及时间
 *      HEADERS：除了BASIC中定义的信息之外，还有请求头和响应头的信息
 *      FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文和元数据
 *
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
