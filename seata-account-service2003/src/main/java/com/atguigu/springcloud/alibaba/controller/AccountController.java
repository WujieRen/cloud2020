package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author rwj
 * @create_time 2021/5/12
 * @description
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;
    @Value("${seata.tx-service-group:a}")
    private String seataTxGroup;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功！");
    }

    @GetMapping("/seata/config")
    public String getSeataConfig() {
        return seataTxGroup;
//        return "s";
    }
}
