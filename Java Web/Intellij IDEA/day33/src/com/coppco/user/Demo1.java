package com.coppco.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.Map;

public class Demo1  extends ActionSupport{
    @Override
    public String execute() throws Exception {
        //完全解耦合

        ActionContext actionContext = ActionContext.getContext();

        Map<String, Object> map = actionContext.getParameters();

        for (Map.Entry<String ,Object> o : map.entrySet()
             ) {
            System.out.println(o.getKey());
            System.out.println(Arrays.toString((String[]) o.getValue()));
        }
        actionContext.put("user", "可以收到吗?");
        return SUCCESS;
    }


}
