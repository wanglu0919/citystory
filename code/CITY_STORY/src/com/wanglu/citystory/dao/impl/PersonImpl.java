package com.wanglu.citystory.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wanglu.citystory.dao.PersonDao;
import com.wanglu.citystory.entity.Person;

public class PersonImpl implements PersonDao {

	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Person getPersonById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person pseron = sqlSession.selectOne("selectPerson", id);
		sqlSession.close();
		return pseron;
	}

}
