package com.coppco.Custom;


//切面类和方法

import org.springframework.stereotype.Component;

//@Component(value = "customAspect")
public class CustomAspect {
    public void log() {
        System.out.println("记录日志!");
    }
}
