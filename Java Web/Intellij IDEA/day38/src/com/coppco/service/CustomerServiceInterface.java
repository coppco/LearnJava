package com.coppco.service;

import com.coppco.domain.Customer;

public interface CustomerServiceInterface {
    public void saveCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public Customer getCustomerById(Long id);
}
