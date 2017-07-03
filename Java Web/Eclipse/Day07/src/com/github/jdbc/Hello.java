package com.github.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.github.tools.DatabaseTools;
import com.mysql.jdbc.Driver;

public class Hello {
	
	/*
	@Test
	public void test() {
		System.out.println("hello");
	}
	*/
	
	@Test
	public void JDBC() throws Exception {	
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
//		com.mysql.jdbc.Driver.class;
		
		System.out.println(Driver.class);
		
		
		//获取连接
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Day07", "root", "123456");

		//编写sql
		String sql = "select * from category;";
		
		//创建语句执行者
		PreparedStatement state = connection.prepareStatement(sql);
		
		//设置参数
		
		//执行sql
		ResultSet resultSet = state.executeQuery();
		
		//处理结果
		while (resultSet.next()) {
			System.out.println(resultSet.getString("cid") + "::" + resultSet.getString("name"));
		}
		
		//释放资源
		resultSet.close();
		state.close();
		connection.close();
		
		
	}
	
	
	@Test
	public void insertData() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			//获取连接
			connection = (Connection) DatabaseTools.getMySQLConnection("localhost", "3306", "Day07", "root", "123456");
			//编写sql
			String sql = "insert into category values(?,?);";
			//语句执行者
			statement = connection.prepareCall(sql);
			//设置参数
			statement.setString(1, "c005");
			statement.setString(2, "办公用品");
			//执行sql(没有参数)
			int result = statement.executeUpdate();
			//处理结果
			
			if (result == 1) {
				System.out.println("成功");
			} else {
				System.out.println("失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放资源
			DatabaseTools.closeCResource(connection, statement, resultSet);
		}
	}
	

}
