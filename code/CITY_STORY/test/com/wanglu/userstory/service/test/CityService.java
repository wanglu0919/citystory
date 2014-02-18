package com.wanglu.userstory.service.test;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanglu.citystory.entity.City;
import com.wanglu.citystory.entity.Province;
import com.wanglu.citystory.entity.User;
import com.wanglu.citystory.service.ICityService;
import com.wanglu.citystory.service.IProvinceService;
import com.wanglu.citystory.service.IUserService;

public class CityService {
	private ICityService cityService;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:META-INF/applicationContext.xml" });
		cityService = (ICityService) context.getBean("cityService");

	}

	@Test
	public void getCitysByProvinceId(){
			
		List<City> citys=cityService.getCitysByProvinceId("f2be7a8d-7a01-4cea-8fa2-69fe50eb1cb9");
		
		for(City city : citys){
			System.out.println(city.getName());
		}
		
	}
	
	
	@Test
	public void getCityById(){
		City city=cityService.getCityById("232333");
		System.out.println(city.getProvince().getName());
		
	}

}
