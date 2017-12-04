package com.coppco.shiro;

import com.coppco.utils.Encrypt;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    //重写密码比较器的方法, token代表用户输入的用户名和密码, info是从数据库得到的用户名和加密的密码
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        System.out.println("密码比较器");
        //1.向下转型
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2.加密密码
        String password = Encrypt.md5(new String(upToken.getPassword()), upToken.getUsername());

        //3.从数据库取密码
        Object obj = info.getCredentials();

        //4.比较
        return this.equals(password, obj);
    }
}
