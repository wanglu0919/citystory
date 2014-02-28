package com.wanglu.citystory.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wanglu.citystory.entity.Province;
import com.wanglu.citystory.service.IProvinceService;

@Controller
@RequestMapping("/admin")
public class ProvinceController {

	@Resource
	IProvinceService provinceService;
	@RequestMapping("/provinces")
	public String toProvinces(Model model){
		
		List<Province> provinces=provinceService.getAllProvinces();
		model.addAttribute("provinces", provinces);
		return "provinces";
	}
	
	
	@RequestMapping("/to_add_province")
	public String toAddProvince(){
		
		return "add_province";
	}
	
	@RequestMapping(value="/add_province",method=RequestMethod.POST)
	public String addProvince(Model model,@RequestParam String provinceName){
		Province province=new Province();
		province.setId(UUID.randomUUID().toString());
		province.setName(provinceName);
		boolean add=provinceService.addProvince(province);
		
		if(add){
			model.addAttribute("result", "添加成功");
		}else{
			model.addAttribute("result", "添加失败 ");
		}
		
		
		
		return "add_province";
		
	}
	
}
