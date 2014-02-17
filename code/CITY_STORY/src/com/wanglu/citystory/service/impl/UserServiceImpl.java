package com.wanglu.citystory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanglu.citystory.dao.UserDao;
import com.wanglu.citystory.entity.User;
import com.wanglu.citystory.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserDao userDao;
	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

}
