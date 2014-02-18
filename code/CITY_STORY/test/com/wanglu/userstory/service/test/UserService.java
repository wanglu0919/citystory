package com.wanglu.userstory.service.test;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanglu.citystory.entity.User;
import com.wanglu.citystory.service.IUserService;

public class UserService {
	private IUserService userService;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:META-INF/applicationContext.xml" });
		userService= (IUserService) context.getBean("userService");
		
		System.out.println(userService);
	}
	
	@Test
	public void addUser(){
		
		User user =new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("大家好");
		user.setAge(15);
		user.setCityId("asdff");
		
		userService.addUser(user);
		
	}

}
