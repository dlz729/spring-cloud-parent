package com.example.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者启动类
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient //开启Eureka客户端发现功能
@EnableCircuitBreaker  //开启熔断
//@SpringCloudApplication   //SpringCloudApplication包含上面三个注解
@EnableFeignClients //开启Feign功能
public class Application_Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Application_Consumer.class);
    }

    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //随机策略
        return new RandomRule();
        // return new RetryRule();
        //return new WeightedResponseTimeRule();
    }
}
