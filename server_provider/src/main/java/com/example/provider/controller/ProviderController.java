package com.example.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暴露服务
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @RequestMapping(value = "/get")
    public String getData() {
        return "服务提供者，提供了数据";
    }
}
