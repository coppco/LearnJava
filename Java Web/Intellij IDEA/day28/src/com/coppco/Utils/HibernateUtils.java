package com.coppco.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
    Hibernate的工具类
 */
public class HibernateUtils {

    private final static Configuration CONFIG;
    private final static SessionFactory FACTORY;

    static  {
        CONFIG = new Configuration().configure();
        FACTORY = CONFIG.buildSessionFactory();
    }

    /*
     * 从工厂中获取Session对象
     */
    public static Session getSession() {
        return FACTORY.openSession();
    }

    /**
     * 从Thread
     * @return
     */
    public static Session getCurrentSession() {
        //需要在配置文件中配置:
        return FACTORY.getCurrentSession();
    }
}
