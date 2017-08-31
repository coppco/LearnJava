package com.coppco.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.coppco.DataSourceUtils.DataSourceUtils;
import com.coppco.dao.AccountDao;

public class AccountService {

	public static void account(String fromuser, String touser, String amount) throws Exception {
		// TODO Auto-generated method stub
		
		//开启事务
		Connection connection = null;
		try {
			connection = DataSourceUtils.getConnection();
			//开始手动事务
			connection.setAutoCommit(false);
			
			//转出
			AccountDao.accountOut(connection, fromuser, amount);
			
			int i = 1 % 0; //模拟异常中断
			
			//转入
			AccountDao.accountIn(connection, touser, amount);
			
			//事务提交
			connection.commit();
			
			DataSourceUtils.releaseConnection(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//事务回滚
			connection.rollback();
			DataSourceUtils.releaseConnection(connection);
			throw e;
		}
		
		
		
	}

}
