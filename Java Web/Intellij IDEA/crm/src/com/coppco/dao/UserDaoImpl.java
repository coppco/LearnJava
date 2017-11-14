package com.coppco.dao;

import com.coppco.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @PostConstruct
    private void initialize() {
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public User checkCode(String code) {

        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", code);

        if (null != list && list.size() > 0) {
            return list.get(0);
        }

        return null;

    }

    @Override
    public void saveUser(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public User login(User user) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("user_code", user.getUser_code()));
        detachedCriteria.add(Restrictions.eq("user_password", user.getUser_password()));
        detachedCriteria.add(Restrictions.eq("user_state", "1"));

        List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        /*
        List<User> list = (List<User>)this.getHibernateTemplate().find("from User where user_code = ? and user_password = ? and user_status = 1", user.getUser_code(), user.getUser_password());

        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        */
        return null;
    }
}
