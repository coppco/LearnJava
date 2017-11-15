package com.coppco.domain;

import java.io.Serializable;

public class Dept implements Serializable {
    private String id;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 副部门id
     */
    private Dept parent;
    /**
     * 状态, 1-启用  0-停用
     */
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public Dept getParent() {
        return parent;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
