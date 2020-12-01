package com.example.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dlz
 * @date 2020/10/22
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
        public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
