package com.coppco.ActionInterface;

import com.opensymphony.xwork2.Action;

public class ActionInterface implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println(this.getClass().getName() + "是一个实现了Action接口");
        return SUCCESS;
    }
}