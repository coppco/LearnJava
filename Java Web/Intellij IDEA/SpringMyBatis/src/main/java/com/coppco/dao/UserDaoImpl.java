package com.coppco.dao;

import java.util.List;

import com.coppco.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component(value = "userDao")
@Scope(value = "prototype")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory factory;

	@PostConstruct
	private void initialize() {
		super.setSqlSessionFactory(this.factory);
	}

	public User findUserById(Integer id) {
		//sqlSesion是线程不安全的,所以它的最佳使用范围在方法体内
		SqlSession openSession = this.getSqlSession();
		User user = openSession.selectOne("test.fingUserById", id);
		//整合后会话归spring管理,所以不需要手动关闭.
		//openSession.close();
		return user;
	}

}
