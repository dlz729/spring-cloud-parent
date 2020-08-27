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
@EnableFeignClients("com.example.fegin.service.fegin")         //feign接口的地址
public class Application_Fegin {
    /**
     * 配置文件中配置了开启指定fegin客户端的日志信息之后，
     * 还需要在主类中加入Logger.Level的Bean创建
     *
     * @return
     */
    // @Bean
    // Logger.Level feginLoggerLevel() {
    //     return Logger.Level.FULL;
    // }
    
    public static void main(String[] args) {
        SpringApplication.run(Application_Fegin.class);
    }
}
