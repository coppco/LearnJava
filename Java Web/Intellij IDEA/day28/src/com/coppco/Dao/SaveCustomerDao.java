package com.coppco.Dao;

import com.coppco.Hibernate.Customer;
import com.coppco.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveCustomerDao {
    public void saveCustomer(Customer c) {
        Session session = HibernateUtils.getSession();

        Transaction transaction = session.getTransaction();

        session.save(c);

        transaction.commit();

        session.close();
    }
}
