package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/get")
    public String get() {
        //资源路径 写死的只能访问固定服务
        // String url = "http://127.0.0.1:8001/provider/get";

        String url;
        System.out.println("请求进来了");
        //获取eureka中注册的TEST-PROVIDER的实例
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("TEST-PROVIDER");
        ServiceInstance serviceInstance = serviceInstances.get(0);
        //动态获取服务拼接请求地址
        url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/provider/get";
        return restTemplate.getForObject(url, String.class);
    }
}
