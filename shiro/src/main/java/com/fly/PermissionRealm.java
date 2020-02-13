package com.fly;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class PermissionRealm extends AuthorizingRealm {
    //获取名字
    @Override
    public String getName() {
        return "PermissionRealm";
    }

    //授权操作
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //principalCollection为传入的参数；用户验证凭证信息
        //SimpleAuthenticationInfo认证方法，返回封装信息的第一个参数：用户信息username
        //当前登录用户名信息，用户凭证
        String username=principalCollection.getPrimaryPrincipal().toString();

        //模拟查询数据库，查询用户指定的用户角色
        List<String>roles=new ArrayList<>();
        List<String>permission=new ArrayList<>();
        //假设用户拥有role1角色
        roles.add("role1");
//      假设用户在数据库中拥有user：delete的操作
        permission.add("user:delete");
        //返回当前用户再数据库的角色与权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permission);
        return info;
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
