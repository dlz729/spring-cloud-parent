package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka服务发现
public class Application_Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Application_Consumer.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
