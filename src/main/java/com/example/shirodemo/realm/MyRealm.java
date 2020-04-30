package com.example.shirodemo.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @program: demo
 * @description: 自定义核心组件 Realm
 * @author: HyJan
 * @create: 2020-04-30 14:06
 **/
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 验证消息，这里应该是将说所有的验证数据交给shiro来帮我们进行管理
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 从验证token中获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        // 接下来应该是获取服务器的所有用户，然后判断此用户是否存在了，这里简单写死
        String username = "java";
        if (!username.equals(userName)) {
            throw new UnknownAccountException("账号不存在!");
        }
        // 中间参数是自定义 “凭据，证件”，也就是密码
        return new SimpleAuthenticationInfo(userName,"123",getName());
    }
}
