package com.coppco.Dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


//@Component(value = "userDaoIMP")
public class UserDaoIMP implements UserDao {

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void save() {
        log.info("保存!");
    }

    @Override
    public void update() {
        log.info("更新!");
    }

    @Override
    public void delete() {
        log.info("删除!");
    }

    @Override
    public void all() {
        log.info("哈哈!!!");
    }
}
