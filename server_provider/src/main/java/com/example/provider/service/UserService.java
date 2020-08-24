package com.example.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provider.entity.User;

/**
 * 服务类
 *
 * @author dlz
 * @date 2020/8/20
 * @description
 */
public interface UserService extends IService<User> {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int add(User user);
}
