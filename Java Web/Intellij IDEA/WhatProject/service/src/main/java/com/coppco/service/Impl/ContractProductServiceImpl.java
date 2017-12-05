package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.Contract;
import com.coppco.domain.ContractProduct;
import com.coppco.domain.ExtCproduct;
import com.coppco.domain.Module;
import com.coppco.service.ContractProductService;
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
import java.util.Set;

@Service(value = "contractProductService")
@Scope(value = "prototype")
@Transactional
public class ContractProductServiceImpl implements ContractProductService {

    @Resource(name = "baseDao")
    private BaseDao baseDao;


    public List<ContractProduct> find(String hql, Class<ContractProduct> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    public ContractProduct get(Class<ContractProduct> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    public Page<ContractProduct> findPage(String hql, Page<ContractProduct> page, Class<ContractProduct> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    public void saveOrUpdate(ContractProduct entity) {
        double amount = 0;
        if (UtilFuns.isEmpty(entity.getId())) {
            //新增
            if (UtilFuns.isNotEmpty(entity.getPrice()) && UtilFuns.isNotEmpty(entity.getCnumber())) {
                //货物总金额
                amount = entity.getPrice() * entity.getCnumber();
                entity.setAmount(amount);
            }

            //修改购销合同总金额
            Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
            contract.setTotalAmount(contract.getTotalAmount() + amount);

            //保存
            baseDao.saveOrUpdate(contract);
        } else  {
            //修改
            double oldAmount = entity.getAmount();
            if (UtilFuns.isNotEmpty(entity.getPrice()) && UtilFuns.isNotEmpty(entity.getCnumber())) {
                //货物总金额
                amount = entity.getPrice() * entity.getCnumber();
                entity.setAmount(amount);
            }

            //修改购销合同总金额
            Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
            contract.setTotalAmount(contract.getTotalAmount() - oldAmount + amount);

            //保存
            baseDao.saveOrUpdate(contract);
        }
        baseDao.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<ContractProduct> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    public void deleteById(Class<ContractProduct> entityClass, Serializable id) {
        baseDao.deleteById(entityClass, id);
    }

    public void delete(Class<ContractProduct> entityClass, Serializable[] ids) {
        for (Serializable id : ids) {
            this.deleteById(entityClass, id);
        }
    }

    public void delete(Class<ContractProduct> entityClass, ContractProduct model) {
        //要删除的货物
        ContractProduct contractProduct = baseDao.get(ContractProduct.class, model.getId());

        //获取当前货物下面的关联物品
        Set<ExtCproduct> extCproducts = contractProduct.getExtCproducts();

        //购销合同
        Contract contract = baseDao.get(Contract.class, model.getContract().getId());

        //遍历附件列表, 修改总金额
        for (ExtCproduct ext: extCproducts) {
            contract.setTotalAmount(contract.getTotalAmount() - ext.getAmount());
        }

        //购销合同总金额

        contract.setTotalAmount(contract.getTotalAmount() - contractProduct.getAmount());

        //保存
        baseDao.saveOrUpdate(contract);

        //删除货物对象 附件对象   级联删除cascade="all" <set name="extCproducts" cascade="all" inverse="true">
        baseDao.deleteById(ContractProduct.class, model.getId());
    }
}
