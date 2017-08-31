package com.coppco.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.coppco.domain.User;
import com.coppco.utils.DataSourceUtils;

public class UserDao {

	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public User findUserByUsername(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from user where username = ? limit 1";
		
		return runner.query(sql, new BeanHandler<>(User.class), username);
	}

}
