package com.example.fegin.service.fegin;

import com.example.api.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author dlz
 * @date 2020/8/26
 * @description
 */
@FeignClient(value = "TEST-PROVIDER")
public interface RefactorHelloService extends HelloService {
}
