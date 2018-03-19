package com.gsh.dao;

import java.util.List;

import com.gsh.base.BaseDAO;
import com.gsh.model.City;
import com.gsh.model.Province;

public interface ProvinceDao extends BaseDAO<Province>{
	List<City> findCitiesByProId(int parseInt) throws Exception;
}
