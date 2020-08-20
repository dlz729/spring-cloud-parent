package com.example.hystrix.consumer.factory;

import com.example.hystrix.consumer.controller.ProviderClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 后备工厂
 *
 * @author dlz
 * @date 2020/8/19
 * @description
 */
@Component
public class ProviderClientFactory implements FallbackFactory<ProviderClient> {
    @Override
    public ProviderClient create(Throwable cause) {
        return new ProviderClient() {
            @Override
            public String get(String num) {
                return "Feign调用失败";
            }
        };
    }
}
