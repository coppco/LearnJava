package com.coppco.service;

import java.sql.SQLException;

import com.coppco.bean.User;
import com.coppco.dao.UserDao;

public class UserService {

	/**
	 * 用户登录	
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 * @throws SQLException
	 */
	public static User getUserByNameAndPassword(String username, String password) throws SQLException {
		return UserDao.queryUserWithNameAndPassword(username, password);
	}

	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public static int regist(User user) throws SQLException {
		return UserDao.addUser(user);
	}

}
