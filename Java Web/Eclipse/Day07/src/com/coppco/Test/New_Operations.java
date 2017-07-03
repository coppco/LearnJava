package com.coppco.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

public class New_Operations {
	
	@Test
	public void querySQL() throws SQLException {
		
		Connection connection = New_JDBCUtils.getConnection();

		
		//SQL语句
		String query = "select * from category where cid= ?;";
		
		//语句执行者
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
		
		//设置参数, 如果sql语句中有?  需要设置参数
		statement.setString(1, "c005");
		
		//执行语句
		ResultSet result = statement.executeQuery();
		
		
		//处理结果
		while (result.next()) {
//			System.out.println(result.getString("cid") + "::" + result.getString("name"));
			
			System.out.println(result.getString(1) + "::" + result.getString(2));
			
		}

		New_JDBCUtils.closeSource(result, statement, connection);
	}
	
	@Test
	public void update() throws SQLException {
		Connection connection = New_JDBCUtils.getConnection();
		
		//sql
		String sql = "update category set name = ? where cid = ?;";
		
		//语句执行者
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		
		//设置参数
		statement.setString(1, "修改后");
		statement.setString(2, "c005");
		
		//执行语句
		int result = statement.executeUpdate();
		
		if (result == 0) {
			System.out.println("失败");
		} else {
			System.out.println("成功");			
		}
		
		New_JDBCUtils.closeStatement(statement);
		New_JDBCUtils.closeConnection(connection);
		
	}
	
	
	@Test
	public void delete() {
		
	}
	
	
}
