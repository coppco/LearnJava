package com.coppco.service;

import java.sql.SQLException;

import com.coppco.bean.User;
import com.coppco.dao.UserDao;

public class UserService {

	public static User getUserByUsernameAndPassword(String username, String password) throws SQLException {
		return UserDao.queryUser(username, password);
	}


}
