package com.coppco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coppco.DataSourceUtils.DataSourceUtils;


public class AccountDao {

	public static void accountOut(String fromuser, String amount) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = DataSourceUtils.getConnection();
			
			//编写sql
			String sql = "update account set monery = monery - ? where account = ?";
			
			//语句执行者
			statement = connection.prepareStatement(sql);
			
			//设置参数
			statement.setString(1, amount);
			statement.setString(2, fromuser);
			
			//执行
			int i = statement.executeUpdate();
			
			System.out.println("处理出: " +  i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseResource(result, statement, connection);
		}
		
	}

	public static void accountIn(String touser, String amount) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = DataSourceUtils.getConnection();
			
			//编写sql
			String sql = "update account set monery = monery + ? where account = ?";
			
			//语句执行者
			statement = connection.prepareStatement(sql);
			
			//设置参数
			statement.setString(1, amount);
			statement.setString(2, touser);
			
			//执行
			int i = statement.executeUpdate();
			
			System.out.println("处理入: " +  i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseResource(result, statement, connection);
		}
		
	}

	public static void accountOut(Connection connection, String fromuser, String amount) throws SQLException {
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			//编写sql
			String sql = "update account set monery = monery - ? where account = ?";
			
			//语句执行者
			statement = connection.prepareStatement(sql);
			
			//设置参数
			statement.setString(1, amount);
			statement.setString(2, fromuser);
			
			//执行
			int i = statement.executeUpdate();
			
			System.out.println("处理入: " +  i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseResultSet(result);
			DataSourceUtils.releaseStatement(statement);
		}
		
	}

	public static void accountIn(Connection connection, String touser, String amount) throws SQLException {
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			//编写sql
			String sql = "update account set monery = monery + ? where account = ?";
			
			//语句执行者
			statement = connection.prepareStatement(sql);
			
			//设置参数
			statement.setString(1, amount);
			statement.setString(2, touser);
			
			//执行
			int i = statement.executeUpdate();
			
			System.out.println("处理入: " +  i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceUtils.releaseResultSet(result);
			DataSourceUtils.releaseStatement(statement);
		}
		
	}

}
