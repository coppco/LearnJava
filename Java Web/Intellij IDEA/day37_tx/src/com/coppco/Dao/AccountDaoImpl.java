package com.coppco.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;


@Repository(value = "accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void outMonery(String out, float monery) {
        String sql = "update account set monery = monery -" + monery + "where name ='" + out + "';";

        this.getJdbcTemplate().update(sql);
    }

    @Override
    public void inMonery(String in, float monery) {
        String sql = "update account set monery = monery +" + monery + "where name ='" + in + "';";

        this.getJdbcTemplate().update(sql);
    }

}
