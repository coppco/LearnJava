package com.coppco.service;

import com.coppco.aspect.HJAction;

public interface UserService {
    public void sayName();

    public void sayAge();

    public void sayGenter();

    @HJAction(name = "注解式拦截")
    public void actionAspect();
}
