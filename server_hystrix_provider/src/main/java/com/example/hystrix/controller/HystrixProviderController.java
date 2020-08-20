package com.example.hystrix.controller;

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
@RequestMapping("provider")
public class HystrixProviderController {
    @GetMapping("get/{num}")
    public String get(@PathVariable("num") Integer num) {
        if (num == 123) {
            throw new RuntimeException("FAILED");
        }
        return num + "==SUCCEED";
    }
}
