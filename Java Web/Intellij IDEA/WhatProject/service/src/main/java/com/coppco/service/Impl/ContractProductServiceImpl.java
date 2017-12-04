package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.ContractProduct;
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
		if(UtilFuns.isEmpty(entity.getId())){
			//新增
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

}
