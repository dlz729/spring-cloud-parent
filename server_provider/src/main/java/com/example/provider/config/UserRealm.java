package com.example.provider.config;

import com.example.provider.entity.User2;
import com.example.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * 自定义Realm
 *
 * @author dlz
 * @date 2020/12/1 16:07
 * @description
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行授权......");
        // 获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User2 user = (User2) subject.getPrincipal();
        // 给资源授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission(user.getPerms());
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行认证......");
        // shiro判断逻辑
        UsernamePasswordToken user = (UsernamePasswordToken) authenticationToken;
        User2 realUser = new User2();
        realUser.setLoginName(user.getUsername());
        realUser.setPassWord(String.copyValueOf(user.getPassword()));
        User2 newUser = userService.findUser(realUser);
        if (ObjectUtils.isEmpty(newUser)) {
            return null;
        }
        return new SimpleAuthenticationInfo(newUser, newUser.getPassWord(), "");
    }
}
