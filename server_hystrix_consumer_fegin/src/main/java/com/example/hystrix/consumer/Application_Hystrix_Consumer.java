package com.example.hystrix.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 基于熔断器的消费者（fegin）
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.example.hystrix.consumer.service")
public class Application_Hystrix_Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Application_Hystrix_Consumer.class,args);
    }
}
