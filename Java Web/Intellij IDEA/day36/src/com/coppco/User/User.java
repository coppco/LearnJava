package com.coppco.User;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component(value = "user")
@Scope(value = "prototype")
public class User {

    @Value(value = "张三")
    private String name;

    @Value(value = "28")
    private int age;


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
