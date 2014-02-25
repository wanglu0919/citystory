package com.wanglu.citystory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UploadController {

	@RequestMapping("/to_upload")
	public String toUpload(){
		
		return "uploademo";
	}
}
