package com.coppco.service;

import com.coppco.Dao.SaveCustomerDao;
import com.coppco.Hibernate.Customer;

public class SaveService {
    public void saveService(Customer c) {
        new SaveCustomerDao().saveCustomer(c);
    }

}
