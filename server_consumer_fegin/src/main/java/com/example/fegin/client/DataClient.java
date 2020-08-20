package com.example.fegin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dlz
 * @date 2020/6/23
 * @description
 */

//要调用的服务名称
@FeignClient(value = "TEST-PROVIDER")
//和调用服务controller的一致
@RequestMapping(value = "provider")
public interface DataClient {
    @RequestMapping(value = "get")
    String getData();
}
