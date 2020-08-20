package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class Application_Zuul {
    public static void main(String[] args) {
        SpringApplication.run(Application_Zuul.class);
    }
}
