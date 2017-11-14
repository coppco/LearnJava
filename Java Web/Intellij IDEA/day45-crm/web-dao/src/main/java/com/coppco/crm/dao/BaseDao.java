package com.coppco.crm.dao;

import com.coppco.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface BaseDao<T> {

    public void save(T t);

    public void delete(T t);

    public void update(T t);

    public List<T> findAll();

    public PageBean<T> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria);

}
