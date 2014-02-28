package com.wanglu.citystory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminConsoleController {
	
	
	@RequestMapping("/main")
	public String toMain(){
		
		return "main";
	}
	
	

}
