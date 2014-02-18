package com.wanglu.citystory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hellword")
public class HellwordController {

	
	@RequestMapping(value="/mvc/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String hellwordSpringMVC(@PathVariable int id){
		
		return "hellow";
	
	
		
	
	}
}
