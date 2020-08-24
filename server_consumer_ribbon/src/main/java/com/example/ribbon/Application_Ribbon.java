package com.example.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 负载均衡 服务调用者启动类
 *
 * @author dlz
 * @date 2020/8/19
 * @description
 */

/**
 * 该注解开启断路功能
 */
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class Application_Ribbon {
    public static void main(String[] args) {
        SpringApplication.run(Application_Ribbon.class, args);
    }

    @Bean
    /**
     *  开启负载均衡的功能
     */
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 修改默认的负载均衡策略
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        //随机策略
        return new RandomRule();
        //return new RetryRule();
        //return new WeightedResponseTimeRule();
    }
}
