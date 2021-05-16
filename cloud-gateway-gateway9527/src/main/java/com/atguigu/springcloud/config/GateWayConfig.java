package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rwj
 * @create_time 2021/5/16
 * @description 自定义实现路由,
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routeBuilder =routeLocatorBuilder.routes();
//        routeBuilder.route("custom_route_locator", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        routeBuilder.route("custom_route_locator",
                r -> r.path("/payment/nacos/{id}").uri("lb://nacos-payment-provider")
        );

        return routeBuilder.build();
    }
}
