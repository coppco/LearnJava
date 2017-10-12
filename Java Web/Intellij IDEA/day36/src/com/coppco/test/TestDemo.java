package com.coppco.test;

import com.coppco.User.User;
import com.coppco.User.UserService;
import com.coppco.User.UserServiceImp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class TestDemo {


    /**
     * 原始方式
     */
    @Test
    public void test1() {
        UserService user = new UserServiceImp();
        user.sayHello();
    }

    /**
     * 使用Spring 工厂
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService user = (UserService) context.getBean("userService");

        user.sayHello();
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");

        System.out.print(user);
    }

}
