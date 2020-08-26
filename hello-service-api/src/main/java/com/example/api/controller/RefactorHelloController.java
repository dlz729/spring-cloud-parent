package com.example.api.controller;

import com.example.api.dto.UserVo;
import com.example.api.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/8/26
 * @description
 */
@RestController
public class RefactorHelloController implements HelloService {
    public String hello(String name) {
        return "Hello"+name;
    }

    public UserVo hello(String name, Integer age) {
        return new UserVo(name,age);
    }

    public String hello(UserVo userVo) {
        return "Hello"+userVo.getName()+","+userVo.getAge();
    }
}
