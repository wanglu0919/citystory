package com.wanglu.citystory.app.controller;

import org.springframework.ui.ModelMap;

import com.wanglu.citystory.message.ErrorMessage;

public class BaseController {

	protected void putError(ModelMap modelMap, Integer errCode) {

		modelMap.put("success", false);
		modelMap.put("msg", ErrorMessage.getEmsg(errCode));
		modelMap.put("errcode", errCode);

	}
	
	protected void putError(ModelMap modelMap, String  msg) {

		modelMap.put("success", false);
		modelMap.put("msg", msg);
		modelMap.put("errcode", 0000);

	}

	protected void putSuccess(ModelMap modelMap, Object ob) {

		modelMap.put("success", true);
		modelMap.put("result", ob);

	}

}
