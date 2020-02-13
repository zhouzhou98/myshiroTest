package com.fly;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {
    //获取名字
    @Override
    public String getName() {
        return "MyRealm";
    }

    //授权操作
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证操作
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //通过用户名到数据库中查找认证信息，封装成一个AuthenticationInfo对象返回，方便认证器对象进行对比

        //参数authenticationToken，表示登录时，包装的UserNamePasswordToken

        //获取authenticationToken中的用户名
        String username=authenticationToken.getPrincipal().toString();

        //通过用户名查询数据库，将该用户对应的数据返回
        //假设从数据库返回的是zhangsan 666
        if(!"zhangsan".equals(username)){
            return null;
        }
        String password="666";
        //表示Realm中登录比对信息
        //参数一表示用户信息，一个真实对象
        //参数二表示密码
        //参数三表示当前Realm的名字
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
//        System.out.println(authenticationToken);
        return info;
    }
}
