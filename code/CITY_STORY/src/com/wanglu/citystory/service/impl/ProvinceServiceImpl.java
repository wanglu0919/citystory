package com.wanglu.citystory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanglu.citystory.dao.ProvinceDao;
import com.wanglu.citystory.entity.Province;
import com.wanglu.citystory.service.IProvinceService;

@Service("provinceService")
public class ProvinceServiceImpl implements IProvinceService {

	@Resource
	private ProvinceDao provinceDao;

	@Override
	public List<Province> getAllProvinces() {

		return provinceDao.getAllProvinces();
	}

	@Override
	public boolean addProvince(Province province) {
		return provinceDao.addProvince(province);
	}

	@Override
	public boolean updateProvince(Province province) {
		return provinceDao.updateProvince(province);
	}

	@Override
	public boolean deleteProvince(String id) {
		return provinceDao.deleteProvince(id);
	}

	@Override
	public Province getProvinceById(String id) {
		
		return provinceDao.getProvinceById(id);
	}

}
