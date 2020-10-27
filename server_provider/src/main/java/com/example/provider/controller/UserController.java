package com.example.provider.controller;

import com.example.provider.entity.User;
import com.example.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/user")
@MapperScan(basePackages = {"com.example.provider.mapper"})
@RefreshScope //及时刷新配置，哪个类需要加载配置加哪个类
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${test.name}")
    private String name;

    String msg;

    @RequestMapping("/add")
    public Integer addUser() {
        User u = new User(null, "张三丰", "123");
        Integer result = userService.add(u);
        if (result > 0) {
            log.info("add成功");
        } else {
            log.info("add失败");
        }
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable Integer id) {
        User user = userService.get(id);
        if (!ObjectUtils.isEmpty(user)) {
            log.info(
                    "id:" + id + " " + "loginName:" + user.getLoginName() + " " + "passWord:" + user.getPassWord()
                            + "\n"
                            + "配置文件中的test.name:" + name);
        } else {
            log.info("没有查询到id为" + id + "的用户");
        }
        return user;
    }

    @RequestMapping(value = "/update/{id}")
    public boolean updateUser(@PathVariable Integer id) {
        boolean b = userService.updateUserById(new User(id, "z三丰", "123456"));
        if (b) {
            log.info("修改成功");
        } else {
            log.info("修改失败");
        }
        return b;
    }
}
