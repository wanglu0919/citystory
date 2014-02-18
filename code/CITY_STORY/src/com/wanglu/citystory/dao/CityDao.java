package com.wanglu.citystory.dao;

import java.util.List;

import com.wanglu.citystory.entity.City;

public interface CityDao {
	public List<City> getCitysByProvinceId(String provinceId);
	public City getCityById(String id);
}
