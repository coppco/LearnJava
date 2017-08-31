package com.coppco.service;

import java.sql.SQLException;
import java.util.List;

import com.coppco.bean.Product;
import com.coppco.dao.ProductDao;

public class ProductService {

	public static List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return ProductDao.findAll();
	}

}
