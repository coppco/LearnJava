package com.coppco.service;

import java.sql.SQLException;
import java.util.List;

import com.coppco.dao.CityDao;
import com.coppco.domain.City;

public class CityService {

	public List<City> findCityByID(String pid) throws SQLException {
		return new CityDao().findCityByID(pid);
	}

}
