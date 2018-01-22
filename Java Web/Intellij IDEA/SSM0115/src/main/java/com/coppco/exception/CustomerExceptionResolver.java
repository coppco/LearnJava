package com.coppco.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        e.printStackTrace();
        CustomerException customerException = null;

        //如果抛出的是系统自定义异常则转换
        if(e instanceof CustomerException){
            customerException = (CustomerException)e;
        }else{
            //如果抛出的不是系统自定义异常则重新构造一个系统错误异常。
            customerException = new CustomerException("系统错误，请与系统管理 员联系！");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", customerException.getMessage());
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
