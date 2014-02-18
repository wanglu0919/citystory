package com.wanglu.userstory.service.test;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanglu.citystory.entity.Province;
import com.wanglu.citystory.entity.User;
import com.wanglu.citystory.service.IProvinceService;
import com.wanglu.citystory.service.IUserService;

public class ProvinceService {
	private IProvinceService provinceService;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:META-INF/applicationContext.xml" });
		provinceService = (IProvinceService) context.getBean("provinceService");

	}

	@Test
	public void addProvince() {
		
		for(int i=0;i<10;i++){
			Province province = new Province();
			province.setId(UUID.randomUUID().toString());
			province.setName("安徽");
			provinceService.addProvince(province);
		}
		
		
	
	}
	
	@Test
	public void getAllProvince(){
		List<Province> provinces=provinceService.getAllProvinces();
		
		for(Province province : provinces){
			System.out.println(province.getName());
		}
		
		
	}
	
	@Test
	public void updteProvince(){
		Province province=new Province();
		province.setId("de21ebaf-c139-409d-9518-09f24cfbec28");
		province.setName("更新");
		provinceService.updateProvince(province);
		
	}
	
	@Test
	public void deleteProvince(){
		
		provinceService.deleteProvince("de21ebaf-c139-409d-9518-09f24cfbec28");
	}

}
