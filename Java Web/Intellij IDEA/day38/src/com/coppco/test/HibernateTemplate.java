package com.coppco.test;

import com.coppco.service.CustomerServiceInterface;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class HibernateTemplate {

    @Resource(name = "customerService")
    private CustomerServiceInterface customerService;

    private Logger logger = Logger.getLogger(this.getClass());

    @Test

    public void add() {

    }

    @Test
    public void query() {
        logger.warn(customerService.getCustomerById(2L));
    }
}
