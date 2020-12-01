package com.example.consumer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@RestController
@Api(tags = "用户查询-HTTP")
@RequestMapping(value = "/user")
public class UserController {
    /**
     *  资源路径
     */
    private final String url = "http://127.0.0.1:8001/user/add";

    @ApiOperation("根据Id查询User信息")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "User的id",required = true,paramType ="query")})
    @RequestMapping(value = "/add")
    public String addUser() {
        System.out.println("请求进来了");
        RestTemplate template = new RestTemplate();
        String data = template.getForObject(url, String.class);
        return data;
    }
}
