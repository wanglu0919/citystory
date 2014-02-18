package com.wanglu.citystory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanglu.citystory.dao.CityDao;
import com.wanglu.citystory.entity.City;
import com.wanglu.citystory.service.ICityService;

@Service("cityService")
public class CityServiceImpl implements ICityService {

	@Resource
	private CityDao cityDao;
	@Override
	public List<City> getCitysByProvinceId(String provinceId) {
		
		return cityDao.getCitysByProvinceId(provinceId);
	}

	@Override
	public City getCityById(String id) {
		return cityDao.getCityById(id);
	}

}
