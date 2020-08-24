package com.example.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 改造服务消费方式，Service类
 *
 * @author dlz
 * @date 2020/8/24
 * @description
 */
@Service
public class ConsumerRibbonService {
    @Autowired
    RestTemplate restTemplate;

    private final String URL = "http://TEST-PROVIDER/provider/get";

    @HystrixCommand(fallbackMethod = "getDataByError")
    public String getData() {
        return restTemplate.getForEntity(URL, String.class).getBody();
    }

    private String getDataByError() {
        return "该服务挂掉了";
    }

    /**
     * Netflix Hystrix工作流程
     *
     * 1、创建HystrixCommand或HystrixObservableCommand对象，表示对依赖服务的操作请求，同时传递所需要的参数。
     *      HystrixCommand：用在依赖的服务返回当个操作结果的时候。
     *      HystrixObservableCommand：用在依赖的服务返回多个操作结果的时候。
     * 2、命令执行，一共有四种命令的执行方式，而Hystrix在执行是会根据创建的Command对象以及具体的情况来选择一个执行。
     *      其中HystrixCommand实现了以下两个执行方式：execute（）：同步执行，从依赖的服务返回一个单一的结果对象，或是在发生错误的时候抛出异常。
     *                                                queue（）：异步执行，直接返回一个Future对象，其中包含了服务执行结束时要返回的单一结果对象。
     *      HystrixObservableCommand实现了另外两种执行方式：observe（）：返回Observable对象，它代表了操作的多个结果，它是一个Hot Observable。
     *                                                      toObservable（）：同样返回Observable对象，也代表了操作的多个结果，但它返回的是一个Cold Observable。
     * 3、...
     */
}
