package com.coppco.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable {
    private String id;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 父部门id
     */
    private Dept parent;
    /**
     * 状态, 1-启用  0-停用
     */
    private Integer state;

    /**
     * 一对多 属性Set集合, 并且初始化
     */
    private Set<User> users = new HashSet<User>();

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

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
