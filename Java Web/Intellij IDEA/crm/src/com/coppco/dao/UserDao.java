package com.coppco.dao;

import com.coppco.domain.User;

public interface UserDao {
    User checkCode(String code);

    void saveUser(User user);

    User login(User user);
}
