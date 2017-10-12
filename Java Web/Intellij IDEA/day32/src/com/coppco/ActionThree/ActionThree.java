package com.coppco.ActionThree;

import com.opensymphony.xwork2.ActionSupport;

public class ActionThree extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println(this.getClass().getName()+"继承了ActionSupport类");
        return super.execute();
    }
}
