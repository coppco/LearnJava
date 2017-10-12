package com.coppco.Aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component(value = "aspectCustomer")
@Aspect()
public class AspectCustomer {
    private Logger log = Logger.getLogger(this.getClass());

    @Before(value = "execution(public void com.coppco.Demo1.CustomerImpl.*(..))")
    public void log() {
    log.warn("记录日志~~~~~~~~~~~~~~~~~~~~~~");
    }

    @After(value = "execution(public void com.coppco.Demo1.CustomerImpl.*(..))")
    public void end() {log.warn("记录日志完成~~~~~~~~~~~~~~~~~~~~~~~~~~~");}


    @AfterReturning(value = "AspectCustomer.all()")
    public void log1() {
        log.warn("all");
    }

    @Pointcut(value = "execution(public void com.coppco.Demo1.CustomerImpl.*(..))")
    public void all() {

    }
}
