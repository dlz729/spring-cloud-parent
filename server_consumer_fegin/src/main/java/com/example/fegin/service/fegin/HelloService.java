package com.example.fegin.service.fegin;

import com.example.fegin.config.DisableHystrixConfiguration;
import com.example.fegin.config.FullLogConfiguration;
import com.example.fegin.entity.vo.UserVo;
import com.example.fegin.hystrix.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通过@FeignClient注解指定服务名称来绑定服务，然后再使用SpringMVC的注解来绑定具体该服务提供的REST接口
 * 在定义各参数绑定时，@RequestParam、@RequestHeader等可以指定参数名称的注解，它们的value千万不能少。不然会抛出IllegalStateException异常
 *
 * @author dlz
 * @date 2020/8/26
 * @description
 */
@FeignClient(value = "TEST-PROVIDER", configuration = FullLogConfiguration.class, fallback = HelloServiceFallback.class)
@Component
public interface HelloService {

    /**
     * 无参调用
     *
     * @return
     */
    @RequestMapping("/provider/get")
    String getData();

    /**
     * 单个参数调用
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/provider/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    /**
     * 两个参数调用
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/provider/hello2", method = RequestMethod.GET)
    UserVo hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    /**
     * 对象类型参数调用
     *
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/provider/hello3", method = RequestMethod.POST)
    String hello(@RequestBody UserVo userVo);
}
