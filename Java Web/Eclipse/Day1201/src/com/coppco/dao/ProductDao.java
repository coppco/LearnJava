package com.coppco.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.coppco.DataSourceUtils.DataSourceUtils;
import com.coppco.bean.Product;

public class ProductDao {

	public static List<Product> findAll() throws SQLException {
		//获取数据
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		
		return runner.query(sql, new BeanListHandler<>(Product.class));
	}

}
