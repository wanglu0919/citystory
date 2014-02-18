package com.wanglu.citystory.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wanglu.citystory.dao.CityDao;
import com.wanglu.citystory.entity.City;

public class CityDaoImpl extends BaseImpl implements CityDao {

	@Override
	public List<City> getCitysByProvinceId(String provinceId) {
		SqlSession sqlSession=getSession();
		List<City> citys=sqlSession.selectList("getCityByProvinceIds", provinceId);
		sqlSession.close();
		return citys;
	}

	@Override
	public City getCityById(String id) {
		SqlSession sqlSession=getSession();
		City city=sqlSession.selectOne("getCityById", id);
		sqlSession.close();
		return city;
	}

}
