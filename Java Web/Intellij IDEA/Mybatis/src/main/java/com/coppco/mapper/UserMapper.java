package com.coppco.mapper;

import com.coppco.pojo.Orders;
import com.coppco.pojo.QueryVo;
import com.coppco.pojo.User;

import java.util.List;

public interface UserMapper {

    public User fingUserById(Integer id);

    public List<User> findUserByUsername(String username);

    public void insetUser(User user);

    public List<User> findUserByVo(QueryVo vo);

    public Long findUserCount();


    public List<User> findUserByUsernameAndSex(User vo);

    public List<Orders> findOrdersAndUsers();

    public List<User> findUserAndOrders();

}
