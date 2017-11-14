package com.coppco.action;

import com.opensymphony.xwork2.ActionSupport;



public class HelloAction extends ActionSupport {

    public String execute() {
        System.out.println("执行了");
        return SUCCESS;
    }
}
