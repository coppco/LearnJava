package com.coppco.test;

import com.coppco.Demo1.Teacher;
import com.coppco.Demo1.UserService;
import com.coppco.Demo1.UserServiceImp;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;


public class TestLog4j {

    private Logger log = Logger.getLogger(TestLog4j.class);

    @Test
    public void test() {
        log.info("这是info模式!!!");
        log.debug("这是DEBUG模式!!!");
        log.error("这是error模式!!!");
    }

    @Test
    public void test1() {
        UserService userService = new UserServiceImp();
        userService.sayHello();

    }

    @Test
    public void test2() {
        UserService userService = new UserServiceImp();
        userService.sayHello();

    }

    @Test
    public void test3() {
        /*创建工厂, 加载配置文件*/
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* 从工厂获取对象 */
        UserService userService = (UserService) ac.getBean("userService");
        userService.sayHello();

        ((ClassPathXmlApplicationContext)ac).close();
    }


    @Test
    public void test4() {
        /*创建工厂, 加载配置文件*/
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* 从工厂获取对象 */
        Teacher teacher = (Teacher) ac.getBean("teacher");
        log.info(teacher);
    }

    @Test
    public void test5() {
        //使用web工厂



//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }
}
