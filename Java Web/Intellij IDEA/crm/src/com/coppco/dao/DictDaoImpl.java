package com.coppco.dao;

import com.coppco.domain.Dict;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Repository(value = "dictDao")
public class DictDaoImpl extends HibernateDaoSupport implements DictDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @PostConstruct
    private void initialize() {
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Dict> findByCode(String dict_type_code) {
        return (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code = ?", dict_type_code);
    }
}
