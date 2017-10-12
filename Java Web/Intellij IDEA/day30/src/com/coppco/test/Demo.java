package com.coppco.test;

import com.coppco.Utils.HibernateUtils;
import com.coppco.domain.Customer;
import com.coppco.domain.Linkman;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Demo {

    /**
     * 测试1对多
     */

    @Test

    public void run1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Customer c = new Customer();
        c.setCust_name("美美");

        Linkman l1 = new Linkman();
        l1.setLkm_name("熊大");

        Linkman l2 = new Linkman();
        l2.setLkm_name("熊二");

        //双向关联
        c.getLinkmans().add(l1);
        c.getLinkmans().add(l2);

        l1.setCustomer(c);
        l2.setCustomer(c);

        session.save(c);
        session.save(l1);
        session.save(l2);

        transaction.commit();
    }
}
