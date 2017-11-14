package com.coppco.service;

import com.coppco.domain.Customer;
import com.coppco.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
	
	public void save(Customer customer);


	PageBean<Customer> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria);

	Customer findById(Long cust_id);

    void update(Customer customer);

    void delete(Customer c);

    List<Customer> findAll();
}
