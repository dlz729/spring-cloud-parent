package com.example.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@RestController
@Api(tags = "用户查询-服务名选择服务")
@RequestMapping(value = "/consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/user/{id}")
    @ApiOperation("根据Id查询User信息")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "User的id",required = true,paramType ="query")})
    //@HystrixCommand(fallbackMethod = "queryByIdFallback") // 单个的降级，如果每个请求对应一降级方法，类会很臃肿
    @HystrixCommand
    public String queryById(@PathVariable(value = "id") Integer id) {
        if (id == 1) {
            throw new RuntimeException("太忙了");
        }
        //资源路径 写死的只能访问固定服务
        // String url = "http://127.0.0.1:8001/provider/get";
        // System.out.println("请求进来了");
        // String url;
        // //获取eureka中注册的TEST-PROVIDER的实例
        // List<ServiceInstance> serviceInstances = discoveryClient.getInstances("TEST-PROVIDER");
        // ServiceInstance serviceInstance = serviceInstances.get(0);
        // //动态获取服务拼接请求地址
        // url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/provider/get";
        String url = "http://TEST-PROVIDER/user/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    public String queryByIdFallback(Integer id) {
        return "查询用户信息失败，id:" + id;
    }

    public String defaultFallback() {
        return "默认提示：查询用户信息失败";
    }
}
