package com.coppco.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo {

	@Test
	public void c3p0Demo() throws PropertyVetoException, SQLException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/Day07");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("123456");
		
		
		
		Connection cn = comboPooledDataSource.getConnection();
		
		String sql = "select * from category";
		
		PreparedStatement sm = cn.prepareStatement(sql);
		
		ResultSet set = sm.executeQuery();
		
		while (set.next()) {
			System.out.println(set.getString(1) + ":" + set.getString(2));
		}
		
		sm.close();
		cn.close();
		
	}
	
	//properties
	@Test
	public void c3p0Demo2() throws SQLException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		
		Connection cn = comboPooledDataSource.getConnection();
		
		String sql = "select * from category";
		
		PreparedStatement sm = cn.prepareStatement(sql);
		
		ResultSet set = sm.executeQuery();
		
		while (set.next()) {
			System.out.println(set.getString(1) + ":" + set.getString(2));
		}
		
		sm.close();
		cn.close();
	}
}
