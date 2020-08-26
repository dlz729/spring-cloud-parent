package com.example.provider.controller;

import com.example.provider.entity.vo.UserVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暴露服务
 *
 * @author dlz
 * @date 2020/6/23
 * @description
 */
@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @RequestMapping(value = "/get")
    public String getData() {
        return "服务提供者，提供了数据";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello" + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public UserVo hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new UserVo(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody UserVo userVo) {
        return "Hello" + userVo.getName() + "," + userVo.getAge();
    }
}
