package com.coppco.crm.dao;

import com.coppco.crm.domain.PageBean;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

//    @Resource(name = "");
    public void set2SessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(Object o) {

    }

    public void delete(Object o) {

    }

    public void update(Object o) {

    }

    public List findAll() {
        return null;
    }

    public PageBean findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria) {
        return null;
    }
}
