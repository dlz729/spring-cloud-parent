package com.example.consumer.controller;

import com.example.consumer.client.UserClient;
import com.example.provider.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/10/22
 * @description
 */
@RestController
@Api(tags = "用户查询-Feign")
@RequestMapping("/cf")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;
    
    @GetMapping("/{id}")
    @ApiOperation("根据Id查询User信息")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "User的id",required = true,paramType ="query")})
    public User queryById(@PathVariable(value = "id") Integer id) {
        // return JSONObject.toJSONString(userClient.queryById(id));
        return userClient.queryById(id);
    }
}
