package com.wanglu.citystory.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglu.citystory.entity.City;
import com.wanglu.citystory.service.ICityService;

@Controller
@RequestMapping("/hellword")
public class HellwordController {

	@Resource
	private ICityService cityService;

	@RequestMapping(value = "/mvc/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String hellwordSpringMVC(@PathVariable int id) {

		return "hellow";

	}

	@RequestMapping("/jsp")
	public String getIndexJsp() {
		return "hellword";
	}

	@RequestMapping(value="/complex/{id}",produces="application/json")
	public String complexTest(@PathVariable String id,ModelMap model) {
		City city = cityService.getCityById(id);
		model.addAttribute("city", city);
		return "complex";
	}

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	@ResponseBody
	public City nihao() {

		City city = cityService.getCityById("12324234");

		return city;

	}

	@RequestMapping(value = "/citys", method = RequestMethod.GET)
	@ResponseBody
	public List<City> getCitys() {

		List<City> citys = cityService
				.getCitysByProvinceId("f2be7a8d-7a01-4cea-8fa2-69fe50eb1cb9");

		return citys;

	}
}
