package com.example.provider.controller;

import com.example.provider.entity.User;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    String msg;

    @RequestMapping("add")
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

    @RequestMapping("get/{id}")
    public String getUser(@PathVariable Integer id) {
        User user = userService.get(id);
        if (!ObjectUtils.isEmpty(user)) {
            msg = "查询到了id为" + id + "的用户";
        } else {
            msg = "没有查询到id为" + id + "的用户";
        }
        return msg;
    }
}
