package com.wanglu.citystory.entity;

/**
 * 
 * @author wanglu
 * 管理员
 *
 */
public class Admin {

	public static final String ADMIN_SESSION_KEY="admin_session_ket";
	private String id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String  name;
	private String password;
	
	
}
