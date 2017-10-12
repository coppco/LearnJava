package com.coppco.Demo1;

import com.coppco.test.TestLog4j;
import org.apache.log4j.Logger;

public class UserServiceImp implements UserService {
    private Logger log = Logger.getLogger(TestLog4j.class);

    private String name;
    private Teacher teacher;

    public UserServiceImp() {

    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserServiceImp(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    @Override
    public void sayHello() {
        log.info("实现类1!!!!");
        if (null != teacher) {
            log.info(teacher.toString());
        }
    }

    public void init() {
        log.info("初始化!!!");
    }

    public void destory() {
        log.info("销毁了!!!");
    }

    @Override
    public String toString() {
        return "UserServiceImp{" +
                "name='" + name + '\'' +
                '}';
    }
}
