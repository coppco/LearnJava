package com.coppco.domain;

import java.util.HashSet;
import java.util.Set;

public class Role extends BaseEntity {

    /**
     * 用户id
     */
    private String id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序号
     */
    private String orderNo;

    /**
     * 角色和用户关系: 多对多
     */
    private Set<User> users = new HashSet<User>(0);
    /**
     * 角色和模块关系: 多对多
     */
    private Set<Module> modules = new HashSet<Module>(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
