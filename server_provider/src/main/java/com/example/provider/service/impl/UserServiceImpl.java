package com.example.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provider.entity.User;
import com.example.provider.mapper.UserMapper;
import com.example.provider.redis.RedisUtil;
import com.example.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        log.info("新增开始......");
        Integer result = baseMapper.insert(user);
        //不设置缓存时间
        redisUtil.set(user.getId().toString(), user);
        log.info("新增结束......");
        return result;
    }

    @Override
    public User get(Integer id) {
        User user;
        log.info("查询开始......");
        user = (User) redisUtil.get(id.toString());
        if (ObjectUtils.isEmpty(user)) {
            log.info("在redis缓存中没有查询到该用户,需要到数据库去查询......");
            user = baseMapper.selectById(id);
            if (ObjectUtils.isEmpty(user)) {
                log.info("在数据库中也没有查询到该用户,该用户不存在......");
            } else {
                log.info("在数据库中查询到了该用户,需要将它添加到redis缓存中......");
                redisUtil.set(id.toString(), user);
            }
        } else {
            log.info("在redis缓存中查询到该用户，不需要到数据去查询......");
        }
        log.info("查询结束......");
        return user;
    }

    @Override
    public boolean updateUserById(User user){
        boolean b=userMapper.updateUserById(user);
        if(b){
            //修改成功更新redis缓存
            redisUtil.set(user.getId().toString(),user);
            log.info("修改成功，并将修改后的信息更新到redis缓存中......");
        }
        return b;
    }
}
