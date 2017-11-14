package com.coppco.dao;

import com.coppco.HJLog;
import com.coppco.domain.PageBean;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/***
 * 公共Dao实现类的抽象类, 以后所有Dao的实现类都需要继承该实现类
 * @param <T>
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    /**
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @PostConstruct
    private void initialize() {
        super.setSessionFactory(sessionFactory);
    }
    */

    @Resource(name="sessionFactory")
    public void set2SessionFactory(SessionFactory sessionFactory){
        // 关键，调用父类的方法
        super.setSessionFactory(sessionFactory);
    }

    private Class<T> clazz;

    /**
     * 获取clazz名称
     */
    public BaseDaoImpl() {
        Type genType = getClass().getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            clazz = (Class) params[0];
            HJLog.logger.warn("类型是: ==============" + clazz.toString() + "==============");
        }
    }

    /**
     * 增加
     * @param t
     */
    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    /**
     * 更新
     * @param t
     */
    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    /**
     * 删除
     * @param t
     */
    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    @Override
    public T findById(Long id) {
        return (T) this.getHibernateTemplate().get(clazz, id);
    }

    /**
     * 查询所有的数据
     * @return
     */
    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
    }

    /**
     * 分页查询
     * @param currentPage 当前页
     * @param pageSize 每页显示条数
     * @param detachedCriteria 查询条件
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public PageBean<T> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria) {
        PageBean<T> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageCode(currentPage);

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
        pageBean.setBeanList(list);
        return pageBean;
    }
}
