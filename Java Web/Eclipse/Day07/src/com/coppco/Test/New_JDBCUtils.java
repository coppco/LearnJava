package com.coppco.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class New_JDBCUtils {
	private static final String DRIVECLASS;
	private New_JDBCUtils() {	}


	private static final String USER;
	private static final String PASSWORD;
	private static final String URL;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		DRIVECLASS = bundle.getString("driverclass");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
		URL = bundle.getString("url");
	}
	
	static {
		try {
			//注册驱动
			Class.forName(DRIVECLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		//获取连接
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	/**
	 * 关闭资源
	 * @param result
	 * @param statement
	 * @param connection
	 */
	public static void closeSource(ResultSet result, Statement statement, Connection connection) {
		closeResultSet(result);
		closeStatement(statement);
		closeConnection(connection);
	}
	
	/**
	 * 关闭结果集
	 * @param resultSet
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				resultSet = null;
			}
		}
	}
	
	/**
	 * 关闭语句执行者
	 * @param statement
	 */
	public static void closeStatement(Statement statement) {
		if (null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				statement = null;
			}
		}
	}
	
	
	/**
	 * 关闭连接
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
	
	
}
