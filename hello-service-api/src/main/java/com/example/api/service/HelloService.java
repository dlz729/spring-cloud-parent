package com.example.api.service;

import com.example.api.dto.UserVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dlz
 * @date 2020/8/26
 * @description
 */
@RequestMapping("/refactor")
public interface HelloService {
    /**
     * api-单参
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    /**
     * api-双参
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    UserVo hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    /**
     * api-对象类型参数
     *
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody UserVo userVo);
}
