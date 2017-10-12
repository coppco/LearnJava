package com.coppco.service;

import com.coppco.dao.CustomerDao;
import com.coppco.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerServiceInterface {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;
    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }
}
