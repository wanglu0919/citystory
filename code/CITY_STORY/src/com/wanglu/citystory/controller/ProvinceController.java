package com.wanglu.citystory.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wanglu.citystory.entity.Province;
import com.wanglu.citystory.service.IProvinceService;
import com.wanglu.citystory.util.ResultConstans;
import com.wangu.citystory.urls.SiteURL;

@Controller
@RequestMapping(SiteURL.ADMIN_ROOT_URL)
public class ProvinceController {

	@Resource
	IProvinceService provinceService;

	@RequestMapping("/view/provinces")
	public String viewProvinces(Model model) {

		List<Province> provinces = provinceService.getAllProvinces();
		model.addAttribute("provinces", provinces);
		return "provinces";
	}

	/**
	 * 添加省份
	 * 
	 * @return
	 */
	@RequestMapping("/view/add/province")
	public String viewAddProvince() {

		return "add_province";
	}

	@RequestMapping("/view/update/province/{provinceId}")
	public String viewUpdateProvince(@PathVariable String provinceId, Model model) {

		Province province = provinceService.getProvinceById(provinceId);

		model.addAttribute("province", province);

		return "update_province";
	}

	/**
	 * 删除
	 * 
	 * @param provinceId
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete/province/{provinceId}")
	public String deleteProvinceById(@PathVariable String provinceId,
			Model model) {

		boolean delete = provinceService.deleteProvince(provinceId);

		if (delete) {
			model.addAttribute(ResultConstans.RESULT_KEY,
					ResultConstans.DELETE_SUCCESS);
		} else {
			model.addAttribute(ResultConstans.RESULT_KEY,
					ResultConstans.DELETE_SUCCESS);
		}

		return "provinces";
	}

	/**
	 * 修改
	 * 
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update/province", method = RequestMethod.POST)
	public String updateProvice(@ModelAttribute Province p, Model model) {

		boolean result = provinceService.updateProvince(p);

		if (result) {
			model.addAttribute(ResultConstans.RESULT_KEY,
					ResultConstans.UPDATE_SUCCESS);
		} else {
			model.addAttribute(ResultConstans.RESULT_KEY,
					ResultConstans.UPDATE_SUCCESS);
		}

		return "update_province";
	}

	/**
	 * 添加省份
	 * 
	 * @param model
	 * @param provinceName
	 * @return
	 */
	@RequestMapping(value = "/add/province", method = RequestMethod.POST)
	public String addProvince(Model model, @RequestParam String provinceName) {

		if (provinceName.equals("")) {

			model.addAttribute(ResultConstans.RESULT_KEY, "省份名称不能为空");

		} else {
			Province province = new Province();
			province.setId(UUID.randomUUID().toString());
			province.setName(provinceName);
			boolean add = provinceService.addProvince(province);

			if (add) {
				model.addAttribute(ResultConstans.RESULT_KEY,
						ResultConstans.ADD_SUCCESS);
			} else {
				model.addAttribute(ResultConstans.RESULT_KEY,
						ResultConstans.ADD_FAIL);
			}

		}

		return "add_province";

	}

}
