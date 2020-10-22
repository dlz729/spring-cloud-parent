package com.example.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author dlz
 * @date 2020/10/22
 * @description
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        //记录所有请求和响应的明细
        return Logger.Level.FULL;
    }
}
