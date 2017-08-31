package com.coppco.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.coppco.DataSourceUtils.DataSourceUtils;
import com.coppco.bean.User;

public class UserDao {

	/**
	 * 从数据库查找用户信息
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 * @throws SQLException
	 */
	public static User queryUserWithNameAndPassword(String username, String password) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		return runner.query(sql, new BeanHandler<>(User.class), username, password);
	}

	/**
	 * 添加数据
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public static int addUser(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into User(username, password, email, name, sex, birthday) values(?,?,?,?,?,?)";
		return runner.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getSex(), user.getBirthday());
	}

}
