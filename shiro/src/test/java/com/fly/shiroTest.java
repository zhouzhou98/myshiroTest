package com.fly;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;

import java.util.Arrays;

/**
 * 测试shiro认证
 */
public class shiroTest {
    @Test
    public void testLogin()throws Exception{
        //1:创建SecurityManager工厂,加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2:通过工厂对象，创建SecurityManager对象
        SecurityManager securityManager=factory.getInstance();
        //3:将securityManager绑定到当前的运行环境中：让系统随时随地都可以访问securityManager对象
        SecurityUtils.setSecurityManager(securityManager);
        //4:获取当前登录的主题,注意此时的主体还没有经过认证
        Subject subject = SecurityUtils.getSubject();
        //5:绑定主体登录的身份/凭证，即账号密码
        //参数1：将要登录的用户名
        //参数2：将要登录的密码
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","666");
        //6:主体登录
        subject.login(token);
        //7:判断登录是否成功
        System.out.println("验证登录是否成功："+subject.isAuthenticated());
        //8:登出（注销）
        subject.logout();
        System.out.println("验证登录是否成功："+subject.isAuthenticated());



        //9实际开发
        try {
            //5:绑定主体登录的身份/凭证，即账号密码
            //参数1：将要登录的用户名
            //参数2：将要登录的密码
           // UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","666");
            //6:主体登录
            subject.login(token);
        }catch (Exception e){
            //登录失败

        }
    }



    @Test
    public void testLoginByMyRealm()throws Exception{
        //1:创建SecurityManager工厂,加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2:通过工厂对象，创建SecurityManager对象
        SecurityManager securityManager=factory.getInstance();
        //3:将securityManager绑定到当前的运行环境中：让系统随时随地都可以访问securityManager对象
        SecurityUtils.setSecurityManager(securityManager);
        //4:获取当前登录的主题,注意此时的主体还没有经过认证
        Subject subject = SecurityUtils.getSubject();
        //5:绑定主体登录的身份/凭证，即账号密码
        //参数1：将要登录的用户名
        //参数2：将要登录的密码
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","666");
        //6:主体登录
        subject.login(token);
        //7:判断登录是否成功
        System.out.println("验证登录是否成功："+subject.isAuthenticated());
        //8:登出（注销）
        subject.logout();
        System.out.println("验证登录是否成功："+subject.isAuthenticated());



        //9实际开发
        try {
            //5:绑定主体登录的身份/凭证，即账号密码
            //参数1：将要登录的用户名
            //参数2：将要登录的密码
            // UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","666");
            //6:主体登录
            subject.login(token);
        }catch (Exception e){
            //登录失败
            e.printStackTrace();
        }
    }






    @Test
    public void testLoginByPasswordRealm()throws Exception{
        //1:创建SecurityManager工厂,加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-cryptography.ini");
        //2:通过工厂对象，创建SecurityManager对象
        SecurityManager securityManager=factory.getInstance();
        //3:将securityManager绑定到当前的运行环境中：让系统随时随地都可以访问securityManager对象
        SecurityUtils.setSecurityManager(securityManager);
        //4:获取当前登录的主题,注意此时的主体还没有经过认证
        Subject subject = SecurityUtils.getSubject();
        //5:绑定主体登录的身份/凭证，即账号密码
        //参数1：将要登录的用户名


        //8:登出（注销）
        try {
            //参数2：将要登录的密码
            UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","666");
            //6:主体登录
            subject.login(token);
            //7:判断登录是否成功
            System.out.println("验证登录是否成功："+subject.isAuthenticated());
            subject.logout();
            System.out.println("验证登录是否成功："+subject.isAuthenticated());

        }catch (Exception e){
            e.printStackTrace();
        }


    }



    @Test
    public void testHasRole()throws Exception{
        //1:创建SecurityManager工厂,加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        //2:通过工厂对象，创建SecurityManager对象
        SecurityManager securityManager=factory.getInstance();
        //3:将securityManager绑定到当前的运行环境中：让系统随时随地都可以访问securityManager对象
        SecurityUtils.setSecurityManager(securityManager);
        //4:获取当前登录的主题,注意此时的主体还没有经过认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","666");
        subject.login(token);
        //进行授权时操作前提：用户必须通过验证
        //判断当前用户是否拥有某个角色:true表示拥有，false：没有
//        System.out.println(subject.hasRole("role1"));
//        //判断当前用户是否拥有一些角色
//        System.out.println(subject.hasAllRoles(Arrays.asList("role1","role2")));
//        System.out.println(subject.hasRoles(Arrays.asList("role1","role2")));
//        System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("role1","role2"))));
//        System.out.println(subject.hasRoles(Arrays.asList("role1","role2","role3")));
//        System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("role1","role2","role3"))));
//        System.out.println("--------------------------------");
//        //判断当前用户是否拥有某个角色，如果拥有角色，不做任何处理，如果没有角色，则报错
//        subject.checkRole("role1");
//        subject.checkRoles("role1","role2");
        System.out.println("-------------------------");
        //判断当前用户是否拥有某几个权限
        System.out.println(subject.isPermitted("user:delete"));
        System.out.println(subject.isPermittedAll("user:delete","user:create"));
        System.out.println(subject.isPermittedAll("user:list","user:create"));
        //判断当前用户是否拥有某几个权限,返回数组
        System.out.println(subject.isPermittedAll("user:delete","user:list"));
        //判断当前用户是否拥有某几个权限,没有返回值
    }





    @Test
    public void testHasRoleByRealm()throws Exception{
        //1:创建SecurityManager工厂,加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission-realm.ini");
        //2:通过工厂对象，创建SecurityManager对象
        SecurityManager securityManager=factory.getInstance();
        //3:将securityManager绑定到当前的运行环境中：让系统随时随地都可以访问securityManager对象
        SecurityUtils.setSecurityManager(securityManager);
        //4:获取当前登录的主题,注意此时的主体还没有经过认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","666");
        subject.login(token);
        //进行授权时操作前提：用户必须通过验证
        //判断当前用户是否拥有某个角色:true表示拥有，false：没有
        System.out.println(subject.hasRole("role1"));

        System.out.println("----------------------------");
        //判断当前用户是否拥有某几个权限
        System.out.println(subject.isPermitted("user:delete"));

    }
}
