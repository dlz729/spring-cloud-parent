package com.example.fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 内部服务启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.example.fegin.client")         //feign接口的地址
public class Application_Fegin {
    public static void main(String[] args) {
        SpringApplication.run(Application_Fegin.class);
    }
}
