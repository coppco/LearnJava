package com.coppco.web.action;

import com.coppco.domain.Customer;
import com.coppco.service.CustomerServiceInterface;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "customerAction")

@Scope(value = "prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    @Resource(name = "customerService")
    private CustomerServiceInterface customerService;

    /**
     * 保存客户
     * @return
     */
    public String add() {
        customerService.saveCustomer(customer);
        return NONE;
    }

    /**
     * 封装Model
     */
    private Customer customer = new Customer();
    @Override
    public Customer getModel() {
        return customer;
    }
}
