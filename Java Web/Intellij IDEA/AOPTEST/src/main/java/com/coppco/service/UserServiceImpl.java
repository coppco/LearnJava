package com.coppco.service;

import com.coppco.aspect.HJAction;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void sayName() {
        System.out.println("名字");
    }

    @Override
    public void sayAge() {
        System.out.println("年龄");
    }

    @Override
    public void sayGenter() {
        System.out.println("性别");
    }

    @Override
    @HJAction(name = "abc")
    public void actionAspect() {
        System.out.println("哈哈");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化之后执行");
    }
    @PreDestroy
    public void destory() {
        System.out.println("销毁之前执行");
    }

}
