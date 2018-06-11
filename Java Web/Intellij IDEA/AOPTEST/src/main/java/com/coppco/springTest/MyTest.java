package com.coppco.springTest;

import com.coppco.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ActiveProfiles(value = "product")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {

//    @Resource(name = "userServiceImpl")
    @Autowired
    private UserService userService;

    @Value("${environment}")
    private String environment;

    @Value("${spring.version}")
    private String version;

    @Repeat(3) //重复3次
    @Test
    public void show() {
//        userService.sayName();
//        userService.sayGenter();
//        userService.sayAge();
        userService.actionAspect();

        System.out.println(version);

        System.out.println(environment);
    }
}
