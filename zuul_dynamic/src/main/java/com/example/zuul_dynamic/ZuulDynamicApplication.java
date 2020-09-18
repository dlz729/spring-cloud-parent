package com.example.zuul_dynamic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

/**
 * 动态网关启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulDynamicApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulDynamicApplication.class).web(true).run(args);
    }

    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}
