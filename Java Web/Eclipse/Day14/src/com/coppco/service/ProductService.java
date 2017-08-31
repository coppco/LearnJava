package com.coppco.service;

import java.sql.SQLException;
import java.util.List;

import com.coppco.dao.ProductDao;
import com.coppco.domain.PageBean;
import com.coppco.domain.Product;

public class ProductService {

	/**
	 * 查询所有商品
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAllProduct() throws SQLException {
		return new ProductDao().findAll();
	}
	
	/**
	 * 添加商品
	 * @param product
	 * @throws SQLException 
	 */
	public void addProduct(Product product) throws SQLException {
		new ProductDao().addProduct(product);
		
	}

	/**
	 * 根据pid查询商品
	 * @param pid
	 * @throws SQLException 
	 */
	public Product getProductById(String pid) throws SQLException {
		return new ProductDao().getProductById(pid);
	}

	/**
	 * 修改商品
	 * @param product
	 * @throws SQLException 
	 */
	public void editProduct(Product product) throws SQLException {
		new ProductDao().editProduct(product);
		
	}

	
	/**
	 * 删除一个商品
	 * @param pid
	 * @throws SQLException
	 */
	public void deleteProductById(String pid) throws SQLException {
		new ProductDao().deleteProductById(pid);
		
	}

	/**
	 * 删除多个商品
	 * @param pids
	 * @throws SQLException 
	 */
	public void deleteProducts(String[] pids) throws SQLException {
		for (String pid : pids) {
			new ProductDao().deleteProductById(pid);
		}
		
	}

	/**
	 * 多条件查询
	 * @param name
	 * @param key
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findProductByCondition(String name, String key) throws SQLException {
		return new ProductDao().findProductByCondition(name, key);
	}

	
	/**
	 * 分页展示
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Product> showProductsByPage(int currentPage, int pageSize) throws SQLException {
		ProductDao dao = new ProductDao();
		//查询当前页面数据
		List<Product> list = dao.findProductsBy(currentPage, pageSize);
		if (currentPage <= 0) {
			currentPage = 1;
		}
		//查询总条数
		int totalCount = dao.getTotalCount();
		if (currentPage >= Math.ceil(1.0 * totalCount / pageSize)) {
			currentPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		}
		return new PageBean<Product>(list, currentPage, pageSize, totalCount);
	}



}
