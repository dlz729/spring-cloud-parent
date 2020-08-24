package com.example.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provider.entity.User;
import com.example.provider.mapper.UserMapper;
import com.example.provider.redis.RedisUtil;
import com.example.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dlz
 * @date 2020/8/20
 * @description
 */
@Service("userService")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RedisUtil redisUtil;
    @Override
    public int add(User user) {
        log.info("新增开始......");
        Integer result=baseMapper.insert(user);
        //设置缓存时间
        redisUtil.set(user.getLoginName(),user.getPassWord(),1000L);
        log.info("新增结束......");
        return result;
    }
}
