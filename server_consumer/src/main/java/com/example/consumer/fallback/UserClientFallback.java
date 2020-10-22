package com.example.consumer.fallback;

import com.example.consumer.client.UserClient;
import com.example.provider.entity.User;
import org.springframework.stereotype.Component;

/**
 * 服务降级处理类
 * @author dlz
 * @date 2020/10/22
 * @description
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public String queryById(Integer id) {
        User user=new User();
        user.setId(id);
        user.setLoginName("用户异常");
        return user.toString();
    }
}
