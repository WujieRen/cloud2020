package com.atguigu.springcloud.alibaba.service;

/**
 * @author rwj
 * @create_time 2021/5/12
 * @description
 */
public interface StorageService {
    //扣减库存
    void decrease(Long productId, Integer count);
}
