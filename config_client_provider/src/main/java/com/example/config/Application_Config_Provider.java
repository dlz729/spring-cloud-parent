package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dlz
 * @date 2020/6/24
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class Application_Config_Provider {
    public static void main(String[] args) {
        SpringApplication.run(Application_Config_Provider.class);
    }
}
