package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.Role;
import com.coppco.service.RoleService;
import com.coppco.utils.Page;
import com.coppco.utils.UtilFuns;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service(value = "roleService")
@Scope(value = "prototype")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource(name = "baseDao")
	private BaseDao baseDao;


	public List<Role> find(String hql, Class<Role> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	public Role get(Class<Role> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	public Page<Role> findPage(String hql, Page<Role> page, Class<Role> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	public void saveOrUpdate(Role entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			//新增
		}
		baseDao.saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<Role> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Role> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);
	}

	public void delete(Class<Role> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(entityClass, id);
		}
	}

}
