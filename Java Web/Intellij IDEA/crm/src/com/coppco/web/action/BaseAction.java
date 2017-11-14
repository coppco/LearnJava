package com.coppco.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.istack.internal.NotNull;

public abstract class BaseAction extends ActionSupport {
    /**
     * 属性驱动, 当前页
     */
    private Integer pageCode = 1;

    public void setPageCode(Integer pageCode) {
        if (pageCode == null) {
            pageCode = 1;
        }
        this.pageCode = pageCode;
    }

    public Integer getPageCode() {
        return pageCode;
    }

    /**
     * 属性驱动, 每页显示数据条数
     */
    private Integer pageSize = 10;


    public void setPageSize(@NotNull Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 压栈
     * @param key
     * @param obj
     */
    public void setVS(String key, Object obj) {
        ActionContext.getContext().getValueStack().set(key, obj);
    }

    /**
     *
     * @param obj
     */
    public void pushVS(Object obj) {
        ActionContext.getContext().getValueStack().push(obj);
    }
}
