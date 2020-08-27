package com.example.fegin.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 构建一个关闭Hystrix的配置类
 *
 * @author dlz
 * @date 2020/8/27
 * @description
 */
@Configuration
public class DisableHystrixConfiguration {
    
    @Bean
    @Scope("prototype")
    public Feign.Builder feginBuilder(){
        return Feign.builder();
    }
}

