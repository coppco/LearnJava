package com.coppco.service.Impl;

import com.coppco.dao.BaseDao;
import com.coppco.domain.User;
import com.coppco.service.UserService;
import com.coppco.utils.Encrypt;
import com.coppco.utils.Page;
import com.coppco.utils.SysConstant;
import com.coppco.utils.UtilFuns;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service(value = "userService")
@Scope(value = "prototype")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource(name = "baseDao")
	private BaseDao baseDao;


	public List<User> find(String hql, Class<User> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	public User get(Class<User> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	public Page<User> findPage(String hql, Page<User> page, Class<User> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	public void saveOrUpdate(User entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			//新增
			String id = UUID.randomUUID().toString();
			entity.setId(id);
			entity.getUserInfo().setId(id);
			entity.setPassword(Encrypt.md5(SysConstant.DEFAULT_PASS, entity.getUserName()));
			baseDao.save(entity);
		} else {
			baseDao.saveOrUpdate(entity);
		}
	}

	public void saveOrUpdateAll(Collection<User> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<User> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);
	}

	public void delete(Class<User> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(entityClass, id);
		}
	}

}
