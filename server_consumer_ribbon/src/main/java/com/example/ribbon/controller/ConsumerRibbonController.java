package com.example.ribbon.controller;

import com.example.ribbon.service.ConsumerRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@RestController
@RequestMapping("consumer")
public class ConsumerRibbonController {
    // @Autowired
    // private RestTemplate restTemplate; 
    //
    // private final String URL="http://TEST-PROVIDER/provider/get";
    //
    // @RequestMapping("get")
    // public String getData(){
    //     String data=restTemplate.getForObject(URL,String.class);
    //     return data;
    // }

    @Autowired
    ConsumerRibbonService consumerRibbonService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getData() {
        return consumerRibbonService.getData();
    }
}
