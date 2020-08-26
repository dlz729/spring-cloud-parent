package com.example.fegin.controller;

import com.example.api.dto.UserVo;
import com.example.api.service.HelloService;

/**
 * @author dlz
 * @date 2020/8/26
 * @description
 */
public class RefactorHelloService implements HelloService {

    public String hello(String name) {
        return null;
    }

    public UserVo hello(String name, Integer age) {
        return null;
    }

    public String hello(UserVo userVo) {
        return null;
    }
}
