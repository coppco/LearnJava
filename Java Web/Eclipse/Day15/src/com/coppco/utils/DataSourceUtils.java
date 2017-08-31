package com.coppco.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	
	/**
	 * 单例获取数据连接池
	 * @return
	 */
	private static final DataSource shareDataSource = new ComboPooledDataSource();
	
	//连接和线程绑定
	private static final ThreadLocal<Connection> threadlocal = new ThreadLocal<>();
	
	/**
	 * 获取数据连接池
	 * @return
	 */
	public static final DataSource getDataSource() {
		return shareDataSource;
	}
	
	/**
	 * 从当前线程获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = threadlocal.get();
		if (null == conn) {
			conn = getDataSource().getConnection();
			threadlocal.set(conn);
		}
		return conn;
	}
	/**
	 * 释放资源
	 * @param resultSet 结果集
	 * @param statement 语句执行者
	 * @param connection 连接
	 */
	public static void releaseResource(ResultSet resultSet, Statement statement, Connection connection) {
		releaseResultSet(resultSet);
		releaseStatement(statement);
		releaseConnection(connection);
	}

	
	/**
	 * 释放结果集
	 * @param resultSet
	 */
	public static void releaseResultSet(ResultSet resultSet) {
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
	 * 释放语句执行者
	 * @param statement
	 */
	public static void releaseStatement(Statement statement) {
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
	 * 释放连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		if (null != connection) {
			try {
				connection.close();
				//还需要和当前线程解绑
				threadlocal.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
	
	/**
	 * 开启事务
	 * @throws SQLException 异常
	 */
	public static void startTransaction() throws SQLException {
		getConnection().setAutoCommit(false);
	}
	
	/**
	 * 事务提交
	 */
	public static void commit() {
		try {
			Connection con = getConnection();
			con.commit();
			con.close();
			threadlocal.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 事务回滚
	 */
	public static void rollback() {
		try {
			Connection con = getConnection();
			con.rollback();
			con.close();
			threadlocal.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
