package com.coppco.dao;

import com.coppco.utils.PageBean;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    /**
     * 主要代码:  使用注解注入, 调用父类的setSessionFactory方法
     * @param factory
     */
    @Resource(name = "sessionFactory")
    public void set2SessionFactory(SessionFactory factory) {
        super.setSessionFactory(factory);
    }

    private Class clazz;


    /**
     * 主要代码: 构造代码块, 获取泛型类型
     */
    {
        Type genType = getClass().getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            clazz = (Class) params[0];
        }
    }

    public void add(T t) {
        this.getHibernateTemplate().save(t);
    }

    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    public T findById(String id) {
        return (T) this.getHibernateTemplate().get(clazz, id);
    }

    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from" + clazz.getSimpleName());
    }

    public PageBean<T> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria) {
        PageBean<T> pageBean = new PageBean<T>();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);

        //查询总数
        detachedCriteria.setProjection(Projections.rowCount());
        List<Number> countList = (List<Number>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (null != countList && countList.size() > 0) {
            int count = countList.get(0).intValue();
            pageBean.setTotalCount(count);
        }

        //查询数据
        detachedCriteria.setProjection(null);
        List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, (currentPage - 1) * pageSize, pageSize);
        pageBean.setResults(list);
        return pageBean;
    }
}
