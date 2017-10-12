package com.coppco.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Map;

public class User extends ActionSupport {

    public String hello() {
        System.out.println("123");

        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> map = actionContext.getParameters();


//        ServletActionContext.getRequest();

        return SUCCESS;
    }

    public String login() {
        System.out.println("456");
        return LOGIN;
    }

    public String logout() {
        System.out.println("789");
        return "index";
    }
}
