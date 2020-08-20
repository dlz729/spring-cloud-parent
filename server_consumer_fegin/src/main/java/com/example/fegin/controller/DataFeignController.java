package com.example.fegin.controller;

import com.example.fegin.client.DataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@RestController
@RequestMapping(value = "consumer")
public class DataFeignController {

    @Autowired
    private DataClient dataClient;

    @RequestMapping(value = "feignGet")
    public String get() {
        return dataClient.getData();
    }
}
