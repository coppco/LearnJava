package com.coppco.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.coppco.DataSourceUtils.DataSourceUtils;
import com.coppco.bean.User;

public class UserDao {

	public static User queryUser(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		System.out.println("username: " + username);
		User user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
		
		if (null != user) {
			System.out.println(user.toString());
		}
		
		return user;
	}
	
	@Test
	public void test() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from user";
		
		User query = queryRunner.query(sql, new BeanHandler<>(User.class));
		
		System.out.println(query.toString());
		
	}

}
