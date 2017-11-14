package com.coppco.service;

import com.coppco.domain.User;

public interface UserService  {

    User checkCode(String code);

    void saveUser(User user);

    User login(User user);
}
