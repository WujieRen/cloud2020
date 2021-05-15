package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rwj
 * @create_time 2021/5/13
 * @description
 */
@RefreshScope //开启配置文件动态刷新功能
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

    @Value("${seata.tx-service-group}")
    private String seataGroup;

    @GetMapping("/seata/config")
    public String getSeataConfit() {
        return seataGroup;
    }
}
