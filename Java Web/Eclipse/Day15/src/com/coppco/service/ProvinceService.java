package com.coppco.service;

import java.sql.SQLException;
import java.util.List;

import com.coppco.dao.ProvinceDao;
import com.coppco.domain.Province;

public class ProvinceService {

	
	public List<Province> findAll() throws SQLException {
		return new ProvinceDao().findAll();
	}

}
