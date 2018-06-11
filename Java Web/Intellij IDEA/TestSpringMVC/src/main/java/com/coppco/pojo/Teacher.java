package com.coppco.pojo;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Teacher {
    private String name;
    private long age;
    private String sex;
    private String schoolName;
    private Date birthday;

    public Teacher(String name, long age, String sex, String schoolName) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.schoolName = schoolName;
    }

    public Teacher() {
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
