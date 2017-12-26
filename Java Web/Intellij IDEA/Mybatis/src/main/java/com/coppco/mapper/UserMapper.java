package com.coppco.mapper;

import com.coppco.pojo.User;

import java.util.List;

public interface UserMapper {

    public User fingUserById(Integer id);

    public List<User> findUserByUsername(String username);

    public void insetUser(User user);

}
