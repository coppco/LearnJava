package com.coppco.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.coppco.domain.City;
import com.coppco.utils.DataSourceUtils;

public class CityDao {

	/**
	 * 查询数据库
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public List<City> findCityByID(String pid) throws SQLException {
		//查询语句
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		//sql语句
		String sql = "select * from City where ProvinceID = ?";
		
		return queryRunner.query(sql, new BeanListHandler<>(City.class), pid);
	}

}
