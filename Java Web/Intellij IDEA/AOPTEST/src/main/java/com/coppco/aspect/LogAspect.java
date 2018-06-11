package com.coppco.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//定义切面类的注解
@Aspect
//定义Bean的注解
@Component
public class LogAspect {

    //声明建言, 使用@Pointcut定义的切点
    @Before(value="common()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName() + "方法执行前(基于方法规则式拦截)");
    }

    //声明建言, 直接使用拦截规则
    @AfterReturning(value = "execution(public * com..UserServiceImpl.say*(..))")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName() + "方法执行后(基于方法规则式拦截)");
    }

    //定义切点
    @Pointcut(value = "execution(public * com..UserServiceImpl.say*(..))")
    public void common() { }


    //拦截自定义注解
    @Before("@annotation(com.coppco.aspect.HJAction)")
    public void show(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        HJAction annotation = method.getAnnotation(HJAction.class);
        System.out.println(annotation.name() + "-----方法执行后(基于注解规则式拦截)");
    }

}
