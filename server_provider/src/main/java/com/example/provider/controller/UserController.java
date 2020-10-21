package com.example.provider.controller;

import com.example.provider.entity.User;
import com.example.provider.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@RestController
@RequestMapping("/user")
@MapperScan(basePackages = {"com.example.provider.mapper"})
public class UserController {
    @Autowired
    private UserService userService;

    String msg;

    @RequestMapping("/add")
    public String addUser() {
        User u = new User(null, "张三丰", "123");
        Integer result = userService.add(u);
        if (result > 0) {
            msg = "add成功";
        } else {
            msg = "add失败";
        }
        return msg;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUser(@PathVariable Integer id) {
        User user = userService.get(id);
        if (!ObjectUtils.isEmpty(user)) {
            msg = "id:" + id + " " + "lohinName:" + user.getLoginName() + " " + "passWord:" + user.getPassWord();
        } else {
            msg = "没有查询到id为" + id + "的用户";
        }
        return msg;
    }

    @RequestMapping(value = "/update/{id}")
    public String updateUser(@PathVariable Integer id) {
        boolean b = userService.updateUserById(new User(id, "z三丰", "123456"));
        if (b) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        return msg;
    }
}
