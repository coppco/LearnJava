package com.coppco.crm_Test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.coppco.HJLog;
import com.coppco.domain.Customer;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
public class CRM_Test {

    @Test
    /**
     * 测试 把对象转换成json
     */
    public void fastJsonTest1() {
        Customer c = new Customer();
        c.setCust_id(1L);
        c.setCust_name("12306");
        c.setCust_mobile("15105713500");
        String st = JSON.toJSONString(c);

        HJLog.logger.warn(st);
    }

    @Test
    public void fastJsonTest2() {
        List<Customer> list = new ArrayList<>();
        Customer c1 = new Customer();
        c1.setCust_id(1L);
        c1.setCust_name("12306");
        c1.setCust_mobile("15105713500");

        Customer c2 = new Customer();
        c2.setCust_id(2L);
        c2.setCust_name("58");
        c2.setCust_mobile("15105713800");

        list.add(c1);
        list.add(c2);


        String st = JSON.toJSONString(list);
        HJLog.logger.warn(st);
    }

    @Test
    /**
     * FastJson中, 循环引用问题: 默认情况下同一个对象会返回 引用, 而不是json
     */
    public void fastJsonTest3() {
        List<Customer> list = getCustomers();


        //String st = JSON.toJSONString(list);
        String st = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        HJLog.logger.warn(st);
    }

    private List<Customer> getCustomers() {
        List<Customer> list = new ArrayList<>();
        Customer c1 = new Customer();
        c1.setCust_id(1L);
        c1.setCust_name("12306");
        c1.setCust_mobile("15105713500");

        Customer c2 = new Customer();
        c2.setCust_id(2L);
        c2.setCust_name("58");
        c2.setCust_mobile("15105713800");

        list.add(c1);
        list.add(c1);
        list.add(c2);
        return list;
    }

    @Test
    /**
     * FastJson中, DisableCircularReferenceDetect引发的问题, 循环引用问题
     */
    public void fastJsonTest4() {
        List<Customer> list = getCustomers();


        //String st = JSON.toJSONString(list);
        String st = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        HJLog.logger.warn(st);
    }
}
