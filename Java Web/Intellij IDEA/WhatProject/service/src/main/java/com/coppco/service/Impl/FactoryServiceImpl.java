package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.Factory;
import com.coppco.domain.Module;
import com.coppco.service.FactoryService;
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

@Service(value = "factoryService")
@Scope(value = "prototype")
@Transactional
public class FactoryServiceImpl implements FactoryService {

    @Resource(name = "baseDao")
    private BaseDao baseDao;


    public List<Factory> find(String hql, Class<Factory> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    public Factory get(Class<Factory> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    public Page<Factory> findPage(String hql, Page<Factory> page, Class<Factory> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    public void saveOrUpdate(Factory entity) {
        if (UtilFuns.isEmpty(entity.getId())) {
            //新增
        }
        baseDao.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<Factory> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    public void deleteById(Class<Factory> entityClass, Serializable id) {
        baseDao.deleteById(entityClass, id);
    }

    public void delete(Class<Factory> entityClass, Serializable[] ids) {
        for (Serializable id : ids) {
            this.deleteById(entityClass, id);
        }
    }

}
