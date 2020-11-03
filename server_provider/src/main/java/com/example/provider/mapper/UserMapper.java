package com.example.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provider.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 修改
     *
     * @param user
     * @return
     */
    boolean updateUserById(User user);
}
