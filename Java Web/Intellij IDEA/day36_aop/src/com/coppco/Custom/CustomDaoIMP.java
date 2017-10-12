package com.coppco.Custom;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;


public class CustomDaoIMP implements CustomDao {

//    @Value("向弘杰")
    private String name;

//    @Value("男")
    private String sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void logName() {
        log.info(this.name);
    }

    @Override
    public void logSex() {
        log.info(this.sex);
    }
}
