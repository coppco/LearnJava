package com.coppco.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User extends BaseEntity {

    /**
     * 用户id
     */
    private String id;
    /**
     * 所在部门, 用户与部门关系: 多对一关系.数据库字段名DEPT_ID
     */
    private Dept dept;

    /**
     * 用户与角色关系: 多对多
     */
    private Set<Role> roles = new HashSet<Role>(0);

    /**
     * 用户信息, 用户和用户信息关系: 一对一
     */
    private UserInfo userInfo;
    /**
     * 登录名
     */
    private String userName;
    /**
     * 密码, md5加密
     */
    private String password;
    /**
     * 状态
     */
    private Integer state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
