package com.coppco.service;

import com.coppco.dao.LinkmanDao;
import com.coppco.domain.Linkman;
import com.coppco.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "linkmanService")
public class LinkmanServiceImpl implements LinkmanService {

    @Resource(name = "linkmanDao")
    private LinkmanDao linkmanDao;

    @Override
    public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria detachedCriteria) {
        return linkmanDao.findByPage(pageCode, pageSize, detachedCriteria);
    }
}
