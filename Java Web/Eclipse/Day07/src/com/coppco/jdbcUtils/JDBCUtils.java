package com.coppco.jdbcUtils;

import java.util.ResourceBundle;

public class JDBCUtils {
	private static final String PROT;
	private static final String DATABASENAME;
	private static final String USERNAME;
	private static final String HOST;
	private static final String TYPE;
	private static final String PASSWORD;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		PROT = bundle.getString("prot");
		DATABASENAME = bundle.getString("databaseName");
		USERNAME = bundle.getString("username");
		HOST = bundle.getString("host");
		TYPE = bundle.getString("type");
		PASSWORD = bundle.getString("password");		
	}
	
	static {
		if (TYPE.toLowerCase().equals("mysql")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
