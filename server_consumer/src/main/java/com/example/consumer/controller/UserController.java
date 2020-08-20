package com.example.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    /**
     *  资源路径
     */
    private final String url = "http://127.0.0.1:8001/user/add";

    @RequestMapping(value = "/add")
    public String addUser() {
        System.out.println("请求进来了");
        RestTemplate template = new RestTemplate();
        String data = template.getForObject(url, String.class);
        return data;
    }
}
