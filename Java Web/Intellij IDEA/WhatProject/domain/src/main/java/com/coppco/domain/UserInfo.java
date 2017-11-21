package com.coppco.domain;

import java.io.Serializable;
import java.util.Date;

public class UserInfo extends BaseEntity {

    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 直属领导, 用户约直属领导关系: 多对一
     */
    private User manager;
    /**
     * 入职时间
     */
    private Date joinDate;
    /**
     * 薪资
     */
    private Double salary;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别
     */
    private String gender;
    /**
     * 岗位
     */
    private String station;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 学位
     */
    private String degree;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序号
     */
    private String orderNo;

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

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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
}
