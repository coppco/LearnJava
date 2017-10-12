package com.coppco.SpringTest;


import com.coppco.Account.Account;
import com.coppco.Demo1.Customer;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    private Logger log = Logger.getLogger(this.getClass());

//    @Resource(name = "customerImpl")
    @Autowired
    private Customer customer;


    @Autowired()
    private JdbcTemplate template;

    @Test

    public void test1() {
        customer.save();
    }


    /*
    * JdbcTemplate模板类, 原始类
    */

    @Test

    public void testJDBC() {

        //Spring提供了内置的连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.184:3306/springJDBC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //JDBC模板类
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("insert into account VALUES (null, ?, ?)", "李四", "男");

    }

    @Test

    public void testJDBCSpring() {
        template.update("insert into account VALUES (null, ?, ?)", "张三", "男");
    }

    /**
     * 查询所有记录
     */

    @Test
    public void selectAll() {
        List<Account> list = template.query("select * from account;", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setSex(resultSet.getString("sex"));
                account.setMonery(resultSet.getFloat("monery"));
                return account;
            }
        });

        for (Account account:list) {
            log.warn(account);
        }
    }


}