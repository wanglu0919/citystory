package com.wanglu.citystory.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.wanglu.citystory.dao.TopicDao;
import com.wanglu.citystory.entity.Topic;

public class TopicDaoImpl extends BaseImpl implements TopicDao {

	@Override
	public boolean addTopic(Topic topic) {

		SqlSession sqlSession = getSession();

		int result = sqlSession.insert("addTopic", topic);

		sqlSession.close();

		return result != 0;
	}

}
