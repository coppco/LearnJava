package com.coppco.SpringTest;

import com.coppco.Dao.AccountDao;
import com.coppco.Service.AccountService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    private Logger log = Logger.getLogger(this.getClass());

    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.pay("张三", "李四", 100);
    }
}
