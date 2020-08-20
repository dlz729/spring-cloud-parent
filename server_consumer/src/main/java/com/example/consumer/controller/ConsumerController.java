package com.example.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {
    //资源路径
    private final String url = "http://127.0.0.1:8001/provider/get";

    @RequestMapping(value = "/get")
    public String get() {
        System.out.println("请求进来了");
        RestTemplate template = new RestTemplate();
        String data = template.getForObject(url, String.class);
        return data;
    }
}
