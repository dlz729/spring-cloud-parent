package com.example.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 * @author dlz
 * @date 2020/10/22
 * @description
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("-------------------全局过滤器MyGlobalFilter-----------------------");
        String token=exchange.getRequest().getQueryParams().getFirst("token");
        if(StringUtils.isBlank(token)){
            //设置状态码为未授权
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return  chain.filter(exchange);
    }

    public int getOrder() {
        //值越小越先执行
        return 1;
    }
}