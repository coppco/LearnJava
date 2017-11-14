package com.coppco.dao;

import com.coppco.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * 持久层
 *
 * @author Administrator
 */
@Repository(value = "customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

    /**
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @PostConstruct
    private void initialize() {
        this.setSessionFactory(sessionFactory);
    }
    */

    /**
     * 保存客户

    public void save(Customer customer) {
        System.out.println("持久层：保存客户...");
        // 把数据，保存到数据库中
        this.getHibernateTemplate().save(customer);
    }
     */

    /**
     * 分页查询数据
     *
     * @param currentPage      当前页码
     * @param pageSize         每页数量
     * @param detachedCriteria 查询条件封装类
     * @return

    public PageBean<Customer> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria) {
        PageBean<Customer> page = new PageBean<>();
        page.setPageCode(currentPage);
        page.setPageSize(pageSize);

        //记录数

        //设置count(*)
        detachedCriteria.setProjection(Projections.rowCount());
        List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(detachedCriteria);

        if (null != list && list.size() > 0) {
            page.setTotalCount(list.get(0).intValue());
        }

        //查询数据
        //先清空 count(*)
        detachedCriteria.setProjection(null);

        List<Customer> data = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, (currentPage - 1) * pageSize, pageSize);
        page.setBeanList(data);
        return page;
    }
     */

    /**
    @Override
    public Customer findById(Long cust_id) {

        return this.getHibernateTemplate().get(Customer.class, cust_id);
    }
    */

    /**
    @Override
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }
    */
}
