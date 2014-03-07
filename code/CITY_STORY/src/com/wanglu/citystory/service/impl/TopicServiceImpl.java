package com.wanglu.citystory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanglu.citystory.dao.TopicDao;
import com.wanglu.citystory.entity.Topic;
import com.wanglu.citystory.service.ITopicService;

@Service("topicService")
public class TopicServiceImpl implements ITopicService {

	@Resource
	TopicDao topicDao;
	@Override
	public boolean addTopic(Topic topic) {
	
		return topicDao.addTopic(topic);
	}

}
