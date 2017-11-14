package com.coppco.web.action;

import com.coppco.domain.Customer;
import com.coppco.domain.Linkman;
import com.coppco.domain.PageBean;
import com.coppco.service.LinkmanService;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


@Controller(value = "linkmanAction")
@Scope(value = "prototype")
public class LinkmanAction extends BaseAction implements ModelDriven<Linkman> {
    private Linkman linkman = new Linkman();

    @Override
    public Linkman getModel() {
        return linkman;
    }

    @Resource(name = "linkmanService")
    private LinkmanService linkmanService;


    public String findByPage() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Linkman.class);

        //拼接查询条件
        //用户名
        String lkm_name = linkman.getLkm_name();
        if (null != lkm_name && !lkm_name.trim().isEmpty()) {
            detachedCriteria.add(Restrictions.like("lkm_name", "%" + lkm_name + "%"));
        }

        //客户
        Customer customer = linkman.getCustomer();
        if (null != customer && customer.getCust_id() != null) {
            detachedCriteria.add(Restrictions.eq("customer.cust_id", customer.getCust_id()));
        }

        PageBean<Linkman> pageBean = linkmanService.findByPage(getPageCode(), getPageSize(), detachedCriteria);
        setVS("page", pageBean);
        return "page";
    }

    public String initAdd() {
        return "initAdd";
    }
}
