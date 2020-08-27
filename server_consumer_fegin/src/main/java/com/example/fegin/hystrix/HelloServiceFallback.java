package com.example.fegin.hystrix;

import com.example.fegin.entity.vo.UserVo;
import com.example.fegin.service.fegin.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务降级逻辑的实现只需要为Fegin客户端的定义接口编写一个具体的接口实现类。
 * 比如为HelloService接口实现一个服务降级类HelloServiceFallback，
 * 其中的每个重写方法的实现逻辑都可以用来定义相应的服务降级逻辑
 *
 * @author dlz
 * @date 2020/8/27
 * @description
 */
@Component
public class HelloServiceFallback implements HelloService {
    public String getData() {
        return "error";
    }

    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    public UserVo hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
        return new UserVo("未知",0);
    }

    public String hello(@RequestBody UserVo userVo) {
        return "error";
    }
}
