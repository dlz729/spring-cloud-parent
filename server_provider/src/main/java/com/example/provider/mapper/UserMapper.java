package com.example.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provider.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
