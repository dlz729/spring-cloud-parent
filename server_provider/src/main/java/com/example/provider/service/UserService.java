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
     *
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 获得用户
     *
     * @param id
     * @return
     */
    User get(Integer id);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    boolean updateUserById(User user);
}
