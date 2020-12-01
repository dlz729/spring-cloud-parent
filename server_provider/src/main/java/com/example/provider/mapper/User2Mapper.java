package com.example.provider.mapper;

import com.example.provider.entity.User2;
import org.springframework.stereotype.Repository;

/**
 * @author dlz
 * @date 2020/12/1 16:39
 * @description
 */
@Repository
public interface User2Mapper {

    /**
     * 获得用户信息
     *
     * @param user
     * @return
     */
    User2 findUser(User2 user);
}
