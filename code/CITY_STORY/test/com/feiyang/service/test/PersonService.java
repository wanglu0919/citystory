package com.feiyang.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanglu.citystory.entity.Person;
import com.wanglu.citystory.service.IPersonService;
import com.wanglu.citystory.service.impl.PersonServiceImpl;

public class PersonService {

	private IPersonService personImpl;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:META-INF/applicationContext.xml" });
		personImpl= (IPersonService) context.getBean("personService");
	}
	
	@Test
	public void getPersonById(){
		Person person=personImpl.getPersonById(1);
		System.out.println(person.getAge());
	}
}
