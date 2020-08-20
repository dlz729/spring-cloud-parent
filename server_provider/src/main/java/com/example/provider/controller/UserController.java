package com.example.provider.controller;

import com.example.provider.entity.User;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping("add")
    public String addUser(){
        User u=new User(null,"张三丰","123");
        Integer result=userService.add(u);
        String msg;
        if(result>0){
            msg="成功";
        }else{
            msg="失败";
        }
        return msg;
    }
}
