package com.example.hystrix.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@RestController
@RequestMapping("consumer")
public class HystrixConsumerController {

    @Autowired(required = false)
    private ProviderClient providerClient;

    @GetMapping("get/{num}")
    public String get(@PathVariable("num") String num) {
        String data = providerClient.get(num);
        return data;
    }
}
