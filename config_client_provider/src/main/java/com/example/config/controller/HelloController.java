package com.example.config.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/6/24
 * @description
 */
@RestController
@RequestMapping(value = "/config")
public class HelloController {
    @RequestMapping(value = "/hello")
    public String index() {
        return "我是一个数据！";
    }
}
