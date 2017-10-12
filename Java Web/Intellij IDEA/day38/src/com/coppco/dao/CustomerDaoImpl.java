package com.coppco.dao;

import com.coppco.domain.Customer;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component(value = "customerDao")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
    @Override
    public void update(Customer customer) {
        getHibernateTemplate().update(customer);
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory1;

    @PostConstruct
    private void initialize() {
        setSessionFactory(sessionFactory1);
    }

    @Override
    public void save(Customer customer) {
        getHibernateTemplate().saveOrUpdate(customer);
    }


    @Override
    public Customer getCustomerById(Long id) {
        return getHibernateTemplate().get(Customer.class, id);
    }
}
