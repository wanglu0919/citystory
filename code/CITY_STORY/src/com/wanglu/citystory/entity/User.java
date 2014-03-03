package com.wanglu.citystory.entity;

/**
 * 用户信息
 * @author wanglu
 *
 */
public class User {
	
	private String id;
	private String name;
	private int age;
	private String cityId;
	private String cityName;
	private String provinceId;
	private String password;
	private String accessToken;
	private long tokenUpdatetTime;
	private long registTime;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getTokenUpdatetTime() {
		return tokenUpdatetTime;
	}
	public void setTokenUpdatetTime(long tokenUpdatetTime) {
		this.tokenUpdatetTime = tokenUpdatetTime;
	}
	public long getRegistTime() {
		return registTime;
	}
	public void setRegistTime(long registTime) {
		this.registTime = registTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	private String provinceName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	

}
