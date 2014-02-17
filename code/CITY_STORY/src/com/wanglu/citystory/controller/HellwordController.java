package com.wanglu.citystory.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglu.citystory.entity.Person;
import com.wanglu.citystory.service.IPersonService;

@Controller
@RequestMapping("/hellword")
public class HellwordController {

	@Resource
	private IPersonService personService;
	@RequestMapping(value="/mvc/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String hellwordSpringMVC(@PathVariable int id){
		
		Person peson=personService.getPersonById(id);
	
		return peson.getName();
	
	}
}
