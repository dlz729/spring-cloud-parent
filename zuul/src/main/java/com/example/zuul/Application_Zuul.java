package com.example.zuul;

import com.example.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 网关启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringCloudApplication
public class Application_Zuul {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application_Zuul.class).web(true).run(args);
    }
    
    @Bean
    public AccessFilter accessFilter(){
        return  new AccessFilter();
    }
}
