package com.coppco.dao;

import com.coppco.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 抽取公共dao类, 其他的接口都需要继承BaseDao接口
 * @param <T>
 * @Author XHJ
 */
public interface BaseDao<T> {

    public void save(T t);

    public void update(T t);

    public void delete(T t);

    public T findById(Long id);

    public List<T> findAll();

    public PageBean<T> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria);

}
