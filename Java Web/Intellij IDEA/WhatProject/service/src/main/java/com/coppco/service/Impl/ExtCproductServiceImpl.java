package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.ExtCproduct;
import com.coppco.domain.Module;
import com.coppco.service.ExtCproductService;
import com.coppco.service.ModuleService;
import com.coppco.utils.Page;
import com.coppco.utils.UtilFuns;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service(value = "extCproductService")
@Scope(value = "prototype")
@Transactional
public class ExtCproductServiceImpl implements ExtCproductService {

    @Resource(name = "baseDao")
    private BaseDao baseDao;


    public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    public ExtCproduct get(Class<ExtCproduct> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    public Page<ExtCproduct> findPage(String hql, Page<ExtCproduct> page, Class<ExtCproduct> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    public void saveOrUpdate(ExtCproduct entity) {
        if (UtilFuns.isEmpty(entity.getId())) {
            //新增
        }
        baseDao.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<ExtCproduct> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    public void deleteById(Class<ExtCproduct> entityClass, Serializable id) {
        baseDao.deleteById(entityClass, id);
    }

    public void delete(Class<ExtCproduct> entityClass, Serializable[] ids) {
        for (Serializable id : ids) {
            this.deleteById(entityClass, id);
        }
    }

}
