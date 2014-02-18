package com.wanglu.citystory.service;

import java.util.List;

import com.wanglu.citystory.entity.City;

public interface ICityService {
	public List<City> getCitysByProvinceId(String provinceId);
	public City getCityById(String id);
}
