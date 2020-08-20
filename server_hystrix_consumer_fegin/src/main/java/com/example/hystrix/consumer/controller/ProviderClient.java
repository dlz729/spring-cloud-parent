package com.example.hystrix.consumer.controller;

import com.sun.tracing.ProviderFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加一个后备工厂，在失败时使用
 *
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@FeignClient(value = "TEST-HYSTRIX-PROVIDER", fallbackFactory = ProviderFactory.class)
@RequestMapping("provider")
public interface ProviderClient {
    @GetMapping("get/{num}")
    public String get(@PathVariable("num") String num);
}
