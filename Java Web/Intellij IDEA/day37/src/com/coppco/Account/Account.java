package com.coppco.Account;

public class Account {
    private int id;
    private String name;
    private String sex;
    private float monery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", monery=" + monery +
                '}';
    }

    public float getMonery() {
        return monery;
    }

    public void setMonery(float monery) {
        this.monery = monery;
    }
}
