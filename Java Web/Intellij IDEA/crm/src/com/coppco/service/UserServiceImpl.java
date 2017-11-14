package com.coppco.service;

import com.coppco.dao.UserDao;
import com.coppco.domain.User;
import com.coppco.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public User checkCode(String code) {
        return userDao.checkCode(code);
    }

    @Override
    public void saveUser(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        return userDao.login(user);
    }
}
