package com.coppco.service;

import java.sql.SQLException;

import com.coppco.dao.UserDao;
import com.coppco.domain.User;

public class UserService {

	public User findUserForUsername(String username) throws SQLException {
		return new UserDao().findUserByUsername(username);
	}

}
