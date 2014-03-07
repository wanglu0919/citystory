package com.wanglu.userstory.service.test;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanglu.citystory.entity.City;
import com.wanglu.citystory.entity.Province;
import com.wanglu.citystory.entity.ThingType;
import com.wanglu.citystory.entity.Topic;
import com.wanglu.citystory.service.ITopicService;

public class TopicSerivce {
	private ITopicService topicService;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:META-INF/applicationContext.xml" });
		topicService = (ITopicService) context.getBean("topicService");

	}

	@Test
	public void addTopic() {
		Topic topic=new Topic();
		City city=new City();
		city.setId("city_ddd");
		Province p=new Province();
		p.setId("p_id");
		ThingType type=new ThingType();
		type.setId("typeId");
		
		topic.setCity(city);
		topic.setProvince(p);
		topic.setId(UUID.randomUUID().toString());
		topic.setPublishTime(System.currentTimeMillis());
		topic.setTitle("title");
		topic.setContent("content");
		topic.setTingType(type);
		topic.setImageUrl("setImageUrl");
		topic.setUserId("userId");
		
		
		topicService.addTopic(topic);
		
		
		
		

	}

}
