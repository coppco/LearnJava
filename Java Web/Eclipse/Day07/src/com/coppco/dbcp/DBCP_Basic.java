package com.coppco.dbcp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DBCP_Basic {
	@Test
	public void Basic_Use() throws SQLException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/Day07");// jdbc:mysql://localhost:3306/Day07
		ds.setUsername("root");
		ds.setPassword("123456");

		Connection cn = ds.getConnection();

		String sql = "select * from category where name like '%%';";
		PreparedStatement statement = (PreparedStatement) cn.prepareStatement(sql);

		// 设置参数
		// statement.setString(1, "___");

		// 结果
		ResultSet set = statement.executeQuery();
		while (set.next()) {
			System.out.println(set.getString(1) + ":" + set.getString(2));
		}
		statement.close();
		cn.close();
	}

	@Test
	public void Basic_Use2() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/properties.properties"));

		DataSource createDataSource = new BasicDataSourceFactory().createDataSource(properties);

		Connection cn = createDataSource.getConnection();

		String sql = "select * from category where name like '%%';";

		PreparedStatement statement = (PreparedStatement) cn.prepareStatement(sql);

		// 设置参数
		// statement.setString(1, "c007");
		// statement.setString(2, "哈哈");

		// 结果
		ResultSet set = statement.executeQuery();
		while (set.next()) {
			System.out.println(set.getString(1) + ":" + set.getString(2));
		}
		statement.close();
		cn.close();
	}
}
