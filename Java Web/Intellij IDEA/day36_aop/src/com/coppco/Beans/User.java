package com.coppco.Beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "user")
public class User {

    @Value(value = "张三")
    private String name;

    @Value(value = "28")
    private int age;
}
