package com.coppco.commonAdvice;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HJControllerAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception() {
        return "error";
    }
}
