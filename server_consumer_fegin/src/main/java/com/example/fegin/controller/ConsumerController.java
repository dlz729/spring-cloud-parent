package com.example.fegin.controller;

import com.example.fegin.entity.vo.UserVo;
import com.example.fegin.service.fegin.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 该控制类实现对Feign客户端的调用
 *
 * @author dlz
 * @date 2020/8/26
 * @description
 */
@RestController
public class ConsumerController {
    
    @Autowired
    HelloService helloService;
    
    @RequestMapping(value="/consumer-fegin",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.getData();
    }
    
    @RequestMapping(value="/consumer-fegin2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuffer sb=new StringBuffer();
        sb.append(helloService.getData()).append("\t");
        sb.append(helloService.hello("DIDI")).append("\t");
        sb.append(helloService.hello("DIDI",30)).append("\t");
        sb.append(helloService.hello(new UserVo("DIDI",30))).append("\t");        
        return sb.toString();
    }
}
