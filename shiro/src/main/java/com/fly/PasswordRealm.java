package com.fly;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class PasswordRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return "PasswordRealm";
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
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
        //模拟数据库中保存的加密之后的密文
        String password="cd757bae8bd31da92c6b14c235668091";
        //表示Realm中登录比对信息
        //参数一表示用户信息，一个真实对象
        //参数二表示密码
        //参数三表示盐
        //参数四表示当前Realm的名字
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes("zhangsan"), getName());
//        System.out.println(authenticationToken);
        return info;
    }
}
