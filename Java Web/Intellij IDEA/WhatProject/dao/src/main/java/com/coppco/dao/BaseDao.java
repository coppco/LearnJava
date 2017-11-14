package com.coppco.dao;

import com.coppco.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface BaseDao<T> {
    /**
     * 增加
     * @param t
     */
    public void add(T t);

    /**
     * 删除
     * @param t
     */
    public void delete(T t);

    /**
     * 更新
     * @param t
     */
    public void update(T t);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T findById(String id);

    /**
     * 查询所有
     * @return
     */
    public List<T> findAll();

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param detachedCriteria
     * @return
     */
    public PageBean<T> findByPage(Integer currentPage, Integer pageSize, DetachedCriteria detachedCriteria);
}
