package com.example.consumer.client;

import com.example.consumer.config.FeignConfig;
import com.example.consumer.fallback.UserClientFallback;
import com.example.provider.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author dlz
 * @date 2020/10/22
 * @description
 */
@Component
//声明当前类是一个Feign客户端，指定服务名为TEST-PROVIDER
@FeignClient(value = "TEST-PROVIDER", fallback = UserClientFallback.class,
        configuration = FeignConfig.class)
public interface UserClient {

    /**
     * 会帮我们拼接这样的接口地址：http://TEST-PROVIDER/user/get/{id}
     * 该接口地址就是TEST_PROVIDER服务中的/user/get/{id}接口地址
     */
    @GetMapping("/user/{id}")
    User queryById(@PathVariable(value = "id") Integer id);
}
