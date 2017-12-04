package com.coppco.shiro;


import com.coppco.domain.Module;
import com.coppco.domain.Role;
import com.coppco.domain.User;
import com.coppco.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    @Resource(name = "userService")
    private UserService userService;


    //授权: 当jsp页面出现 shiro标签会走这个方法
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");

        //根据realname查找用户
        User user = (User) principalCollection.fromRealm(this.getName()).iterator().next();

        Set<Role> roles = user.getRoles();
        List<String> list = new ArrayList<String>();
        for (Role role: roles) {
            Set<Module> modules = role.getModules();
            for (Module module: modules) {
                list.add(module.getName());
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加用户的模块
        info.addStringPermissions(list);

        return info;
    }

    //认证: 登录时执行
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");

        //向下转型
        UsernamePasswordToken upToken = (UsernamePasswordToken)authenticationToken;

        //查询
        String sql = "from User where state = 1 and userName = ?";
        List<User> userList = userService.find(sql, User.class, new String[]{upToken.getUsername()});

        //判断
        if (null != userList && userList.size() > 0) {
            User user = userList.get(0);
            AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
            return info; //会立即进入密码比较器
        }
        return null;//出现异常
    }
}
