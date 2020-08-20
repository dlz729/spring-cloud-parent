package com.example.provider2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者的启动类2
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class Application_Provider2 {
    public static void main(String[] args) {
        SpringApplication.run(Application_Provider2.class);
    }
}
