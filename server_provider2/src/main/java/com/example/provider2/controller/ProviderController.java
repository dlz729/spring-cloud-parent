package com.example.provider2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@RestController
@RequestMapping("provider")
public class ProviderController {
    @RequestMapping("get")
    public String getData(){
        return "提供了数据222";
    }
}
