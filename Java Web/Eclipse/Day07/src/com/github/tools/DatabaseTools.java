package com.github.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTools {

	private DatabaseTools() {
		super();
	}

	/**
	 * 获取连接
	 * @param host 主机
	 * @param prot 端口
	 * @param databaseName 数据库名称
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getMySQLConnection(String host, String prot, String databaseName, String username,
			String password) throws ClassNotFoundException, SQLException {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 获取连接
		Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + prot + "/" + databaseName,
				username, password);
		return connection;
	}

	/**
	 * 关闭资源
	 * @param connection 连接
	 * @param statement 执行者
	 * @param result 结果
	 * @throws SQLException
	 */
	public static void closeCResource(Connection connection, Statement statement, ResultSet result) {
		//后打开的先关闭
		closeResultSet(result);
		closeStatement(statement);
		closeConnection(connection);
	}
	
	/**
	 * 关闭连接
	 * @param connection 连接
	 */
	public static void closeConnection(Connection connection) {
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			connection = null;
		}
	}
	
	/**
	 * 关闭语句执行者
	 * @param statement 执行者
	 */
	public static void closeStatement(Statement statement) {
		if (null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement = null;
		}
	}
	
	
	/**
	 * 关闭查询结果
	 * @param resultSet 结果
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultSet = null;
		}
	}
	

}
