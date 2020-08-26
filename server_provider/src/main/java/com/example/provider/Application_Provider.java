package com.example.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 服务提供者的启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class Application_Provider {
    public static void main(String[] args) {
        SpringApplication.run(Application_Provider.class);
    }
}
