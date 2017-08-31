package com.coppco.jdbc;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	
	@JDBCInfo(password = "123456", url = "jdbc:mysql://localhost:3306/Day07")
	public static Connection getConnection() throws NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		//获取字节码文件
		Class clazz = JDBCUtils.class;
		
		//获取方法
		Method method = clazz.getMethod("getConnection");
		
		//判断
		if (method.isAnnotationPresent(JDBCInfo.class)) {
			//获取注解
			JDBCInfo info = method.getAnnotation(JDBCInfo.class);
			
			//获取属性
			String driverClass = info.driverClass();
			String url = info.url();
			String username = info.username();
			String password = info.password();
			
			//注册驱动
			Class.forName(driverClass);
			
			//获取连接
			return DriverManager.getConnection(url, username, password);
		}
		return null;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		System.out.println(getConnection());
	}
}
