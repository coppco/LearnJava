package com.coppco.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component(value = "userService")
public class UserServiceImp implements UserService {

    private Logger log = Logger.getLogger(this.getClass());
    @Override
    public void sayHello() {
        log.info("你好吗?");
    }
}
