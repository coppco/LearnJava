package com.coppco.DataSourceUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	
	/**
	 * 单例获取数据源
	 * @return
	 */
	public static final DataSource getDataSource() {
		return new ComboPooledDataSource();
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	//释放资源
	public static void releaseResource(ResultSet resultSet, Statement statement, Connection connection) {
		releaseResultSet(resultSet);
		releaseStatement(statement);
		releaseConnection(connection);
	}
	
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
	
	public static void releaseConnection(Connection connection) {
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
