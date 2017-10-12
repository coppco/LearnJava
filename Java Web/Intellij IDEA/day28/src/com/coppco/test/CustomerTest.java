package com.coppco.test;

import com.coppco.Hibernate.Customer;
import com.coppco.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testSave() {
        /*
        1. 加载配置文件
        2. 创建SessionFactory对象, 生成session
        3. 创建session对象
        4. 开启事务
        5. 编写代码
        6. 提交事务
        7. 释放资源
         */

        //1. 加载配置文件
        Configuration config = new Configuration();
        config.configure();

        //手动加载 映射配置文件
        //config.addResource("com/coppco/Hibernate/Customer.hbm.xml");

        //2. 创建sessionFactory
        SessionFactory sf = config.buildSessionFactory();

        //3. session对象
        Session session = sf.openSession();

        //4. 开启事务
        Transaction trandsation = session.beginTransaction();

        //5. 保存
        Customer customer = new Customer();
        customer.setCust_industry("101");
        customer.setCust_name("测试");

        session.save(customer);

        //6. 提交
        trandsation.commit();

        //7. 释放
        session.close();
        sf.close();

        System.out.println("测试成功!");
    }


//    @Test
    public void testUtils() {
        //1. 获取Session
        Session session = HibernateUtils.getSession();

        //2. 开启事务
        Transaction trandsation = session.beginTransaction();

        //3. 保存
        Customer customer = new Customer();
        customer.setCust_industry("101");
        customer.setCust_name("王辉强");

        session.save(customer);

        //4. 提交
        trandsation.commit();

        //5. 释放
        session.close();
    }

//    @Test

    public void getObject() {
        //1. 获取Session
        Session session = HibernateUtils.getSession();

        //2. 开启事务
        Transaction trandsation = session.beginTransaction();

        Customer c = session.get(Customer.class, 6L);

        System.out.println(c.getCust_name());

        session.close();
    }
}