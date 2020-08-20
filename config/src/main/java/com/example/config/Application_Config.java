package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置中心启动类
 *
 * @author dlz
 * @date 2020/6/24
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer  //启动配置中心服务
public class Application_Config {
    public static void main(String[] args) {
        SpringApplication.run(Application_Config.class);
    }
}
