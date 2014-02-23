package com.wanglu.citystory.entity;

import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="asdfsdf")
public class City {
	private Province province;
	private String id;
	private String name;
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
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
}
