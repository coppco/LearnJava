package com.coppco.dao;

import com.coppco.domain.Customer;

public interface CustomerDao {
    public void save(Customer customer);

    public void update(Customer customer);

    public Customer getCustomerById(Long id);
}
