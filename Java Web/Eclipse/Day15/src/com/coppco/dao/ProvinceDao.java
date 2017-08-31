package com.coppco.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.coppco.domain.Province;
import com.coppco.utils.DataSourceUtils;

public class ProvinceDao {

	public List<Province> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from province";
		return queryRunner.query(sql, new BeanListHandler<>(Province.class));
	} 

}
