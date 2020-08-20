package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心的启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@SpringBootConfiguration
@EnableEurekaServer
@SpringBootApplication
public class Application_Eureka {
    public static void main(String[] args) {
        SpringApplication.run(Application_Eureka.class);
    }
}
