package com.wanglu.citystory.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.wanglu.citystory.dao.UserDao;
import com.wanglu.citystory.entity.User;

public class UserDaoImpl extends BaseImpl implements UserDao {

	@Override
	public boolean addUser(User user) {

		SqlSession sqlSession = getSession();
		int reslut = sqlSession.insert("addUser", user);
		sqlSession.close();
		return reslut != 0;
	}

	@Override
	public User findUserById(String id) {

		return null;
	}

	@Override
	public boolean updateUser() {

		return false;
	}

	@Override
	public User findUserByName(String userName) {

		SqlSession sqlSession = getSession();
		User user = sqlSession.selectOne("findUserByName", userName);
		sqlSession.close();
		return user;
	}

}
