package com.example.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@RestController
@RequestMapping("consumer")
public class ConsumerRibbonController {
    @Autowired
    private RestTemplate restTemplate;
    
    private final String URL="http://TEST-PROVIDER/provider/get";
    
    @RequestMapping("get")
    public String getData(){
        String data=restTemplate.getForObject(URL,String.class);
        return data;
    }
}
