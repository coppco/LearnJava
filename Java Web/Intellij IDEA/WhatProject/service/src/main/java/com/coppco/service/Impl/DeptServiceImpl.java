package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.Dept;
import com.coppco.service.DeptService;
import com.coppco.utils.Page;
import com.coppco.utils.UtilFuns;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service(value = "deptService")
@Scope(value = "prototype")
@Transactional
public class DeptServiceImpl implements DeptService {

	@Resource(name = "baseDao")
	private BaseDao baseDao;


	public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	public Dept get(Class<Dept> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	public Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	public void saveOrUpdate(Dept entity) {
		//1.调用业务方法，实现保存
		if (entity.getParent().getId() == null || entity.getParent().getId().length() == 0) {
			entity.setParent(null);
		}
		if(UtilFuns.isEmpty(entity.getId())){
			//新增
			entity.setState(1);//1启用  0停用  默认为启用
		} else  {
			if (entity.getId().equals(entity.getParent().getId())) {
				entity.setParent(null);
			}
		}
		baseDao.saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<Dept> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Dept> entityClass, Serializable id) {

		//删除父部门下面的子部门
		String sql = "from Dept where parent.id = ?";
		List<Dept> deptList = baseDao.find(sql, entityClass, new Object[]{id});

		if (deptList != null && deptList.size() > 0) {
			for (Dept dept : deptList) {
				deleteById(entityClass, dept.getId());//递归调用
			}
		}
		//删除父部门
//		baseDao.deleteById(entityClass, id);
		Dept dept = baseDao.get(entityClass, id);
		if (dept != null) {
			baseDao.deleteById(entityClass, id);
		}
	}

	public void delete(Class<Dept> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(entityClass, id);
		}
	}

}
