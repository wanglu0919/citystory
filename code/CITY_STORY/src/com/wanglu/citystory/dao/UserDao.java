package com.wanglu.citystory.dao;

import com.wanglu.citystory.entity.User;

public interface UserDao {
	public boolean addUser(User user);
	public User findUserById(String id);
	public boolean updateUser();
	
	public User findUserByName(String userName);
}
