package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.Module;
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

@Service(value = "moduleService")
@Scope(value = "prototype")
@Transactional
public class ModuleServiceImpl implements ModuleService {

    @Resource(name = "baseDao")
    private BaseDao baseDao;


    public List<Module> find(String hql, Class<Module> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    public Module get(Class<Module> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    public Page<Module> findPage(String hql, Page<Module> page, Class<Module> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    public void saveOrUpdate(Module entity) {
        if (UtilFuns.isEmpty(entity.getId())) {
            //新增
        }
        baseDao.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<Module> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    public void deleteById(Class<Module> entityClass, Serializable id) {
        baseDao.deleteById(entityClass, id);
    }

    public void delete(Class<Module> entityClass, Serializable[] ids) {
        for (Serializable id : ids) {
            this.deleteById(entityClass, id);
        }
    }

}
