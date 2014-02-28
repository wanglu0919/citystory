package com.wanglu.citystory.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wanglu.citystory.dao.ProvinceDao;
import com.wanglu.citystory.entity.Province;

public class ProvinceDaoImpl extends BaseImpl implements ProvinceDao {

	@Override
	public boolean addProvince(Province province) {
		SqlSession sqlSession = getSession();

		int reslut = sqlSession.insert("addProvince", province);
		sqlSession.close();

		return reslut != 0;
	}

	@Override
	public boolean updateProvince(Province province) {
		SqlSession sqlSession = getSession();
		int reslut = sqlSession.update("updateProvince", province);
		sqlSession.close();
		return reslut != 0;
	}

	@Override
	public boolean deleteProvince(String id) {
		SqlSession sqlSession = getSession();
		int reslut = sqlSession.delete("deleteProvinceById", id);
		return reslut != 0;
	}

	@Override
	public List<Province> getAllProvinces() {
		SqlSession sqlSession = getSession();
		List<Province> provinces = sqlSession.selectList("getAllProvinces");
		sqlSession.close();
		return provinces;
	}

	@Override
	public Province getProvinceById(String id) {

		SqlSession sqlSession = getSession();
		Province p = sqlSession.selectOne("getProviceById", id);
		
		sqlSession.close();

		return p;
	}

}
