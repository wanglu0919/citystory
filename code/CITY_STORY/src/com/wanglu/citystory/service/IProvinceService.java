package com.wanglu.citystory.service;

import java.util.List;

import com.wanglu.citystory.entity.Province;

/**
 * 
 * @author wanglu
 *省份
 */
public interface IProvinceService {
	public List<Province> getAllProvinces();
	public boolean addProvince(Province province);
	public boolean updateProvince(Province province);
	public boolean deleteProvince(String id);
}
