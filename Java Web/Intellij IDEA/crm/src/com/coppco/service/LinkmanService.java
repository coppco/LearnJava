package com.coppco.service;

import com.coppco.domain.Linkman;
import com.coppco.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkmanService {
    PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria detachedCriteria);
}
