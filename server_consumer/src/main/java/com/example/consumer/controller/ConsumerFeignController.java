package com.example.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.consumer.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/10/22
 * @description
 */
@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public String queryById(@PathVariable(value = "id") Integer id) {
        return JSONObject.toJSONString(userClient.queryById(id));
    }
}
