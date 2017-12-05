package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.Contract;
import com.coppco.service.ContractService;
import com.coppco.utils.Page;
import com.coppco.utils.UtilFuns;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service(value = "contractService")
@Scope(value = "prototype")
@Transactional
public class ContractServiceImpl implements ContractService {

    @Resource(name = "baseDao")
    private BaseDao baseDao;


    public List<Contract> find(String hql, Class<Contract> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    public Contract get(Class<Contract> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    public Page<Contract> findPage(String hql, Page<Contract> page, Class<Contract> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    public void saveOrUpdate(Contract entity) {
        if (UtilFuns.isEmpty(entity.getId())) {
            //新增
            entity.setTotalAmount(0d);
            entity.setState(0); //0 草稿  1 已上报 2 已报运
        }
        baseDao.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<Contract> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    public void deleteById(Class<Contract> entityClass, Serializable id) {
        baseDao.deleteById(entityClass, id);
    }

    public void delete(Class<Contract> entityClass, Serializable[] ids) {
        for (Serializable id : ids) {
            this.deleteById(entityClass, id);
        }
    }

    public void changeState(String ids [] , Integer state) {
        for (String id:ids) {
            Contract contract = baseDao.get(Contract.class, id);
            contract.setState(state);
            baseDao.saveOrUpdate(contract); //可以不添加, 持久层也可以更新
        }
    }

}
