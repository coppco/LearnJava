package com.coppco.service;

import com.coppco.HJLog;
import com.coppco.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coppco.dao.CustomerDao;
import com.coppco.domain.Customer;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户的业务层
 *
 * @author Administrator
 */
@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 保存客户
     */
    public void save(Customer customer) {
        System.out.println("业务层：保存客户...");
        customerDao.save(customer);

    }

    /**
     * 分页查找客户
     * @param currentPage
     * @param pageSize
     * @param detachedCriteria
     * @return
     */
    public PageBean<Customer> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria) {
        return customerDao.findByPage(currentPage, pageSize, detachedCriteria);
    }

    @Override
    public Customer findById(Long cust_id) {
        return customerDao.findById(cust_id);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> findAll() {
        HJLog.logger.warn("1231");
        return customerDao.findAll();
    }
}
