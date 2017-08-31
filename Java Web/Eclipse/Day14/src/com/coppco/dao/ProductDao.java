package com.coppco.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.coppco.domain.Product;
import com.coppco.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from product order by pid desc;";

		return queryRunner.query(sql, new BeanListHandler<>(Product.class));
	}

	public void addProduct(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";

		queryRunner.update(sql, product.getPid(), product.getPname(), product.getMarket_price(),
				product.getShop_price(), product.getPdate(), product.getPdesc());
	}

	/**
	 * 根据pid查找商品
	 * 
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product getProductById(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from product where pid = ?";

		return queryRunner.query(sql, new BeanHandler<>(Product.class), pid);
	}

	/**
	 * 修改商品
	 * 
	 * @param product
	 * @throws SQLException
	 */
	public void editProduct(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "update product set pname = ?, market_price = ? , shop_price = ?, pdesc = ? where pid = ?";

		queryRunner.update(sql, product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPdesc(), product.getPid());

	}

	/**
	 * 删除数据
	 * 
	 * @param pid
	 * @throws SQLException
	 */
	public void deleteProductById(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "delete from product where pid = ?";

		queryRunner.update(sql, pid);

	}

	/**
	 * 根据条件查询
	 * 
	 * @param name
	 * @param key
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findProductByCondition(String name, String key) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from product where 1 != 1";

		ArrayList<String> params = new ArrayList<>();
		if (null != name && name.length() > 0) {
			sql += " or pname like ?";
			params.add("%" + name + "%");
		}

		if (null != key && key.length() > 0) {
			sql += " or pdesc like ?";
			params.add("%" + key + "%");
		}

		if ((null == name || name.length() == 0) && (null == key || key.length() == 0)) {
			sql = "select * from product";
			params.clear();
		}
		/*
		 * sql += " limit 2";
		 */
		return queryRunner.query(sql, new BeanListHandler<>(Product.class), params.toArray());
	}

	public List<Product> findProductsBy(int currentPage, int pageSize) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from product limit ?,?";
		
		return runner.query(sql, new BeanListHandler<>(Product.class), (currentPage - 1) * pageSize, pageSize);
	}

	/**
	 * 查询商品总数
	 * @return
	 * @throws SQLException 
	 */
	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select count(*) from product";
		
		return ((Long) runner.query(sql, new ScalarHandler())).intValue();
	}

}
