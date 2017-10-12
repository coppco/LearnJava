package com.coppco.SpringTest;

import com.coppco.Custom.CustomDaoIMP;
import com.coppco.Dao.UserDao;
import com.coppco.Dao.UserDaoIMP;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Resource
    private UserDaoIMP userDao;

    @Resource
    private CustomDaoIMP customDaoIMP;

    /*日志*/
    private Logger log = Logger.getLogger(this.getClass());

    @Test
    public void test1() {
        userDao.save();

        userDao.update();

        userDao.delete();

        customDaoIMP.logName();
    }


    /**
     * JDK动态代理
     */
    @Test
    public void test2() {
        userDao = new UserDaoIMP();

        UserDao dao = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj =  method.invoke(userDao, args);
                if (method.getName().equals("save")) {
                    log.info("=======================");
                } else if (method.getName().equals("update")) {
                    log.info("-----------------------");
                } else if (method.getName().equals("delete")) {
                    log.info("***********************");
                }
                return obj;
            }
        });

        dao.save();
        dao.update();
        dao.delete();

        dao.all();
    }


    /*
     * CGLIB代理
     */

    @Test

    public void test3() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDaoIMP.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("delete")) {
                    log.info("++++++++++++++++++++++++");
                }
                return methodProxy.invokeSuper(o, objects);
            }
        });

        UserDao dao = (UserDao) enhancer.create();

        dao.delete();
    }


    @Test
    public void test4() {
        customDaoIMP.logSex();
        customDaoIMP.logName();
    }
}
