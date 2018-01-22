package com.coppco.test;


import com.coppco.dao.UserDao;
import com.coppco.mapper.UserMapper;
import com.coppco.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class MyTest {

    @Resource(name = "userDao")
    private UserDao userDao;



    @Test
    public void testYuanShengDao() {
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Test
    public void testMapper() {
        User user = userMapper.fingUserById(1);
        System.out.println(user);
    }
}
