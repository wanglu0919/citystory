package com.wanglu.citystory.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanglu.citystory.entity.OAuth;
import com.wanglu.citystory.entity.User;
import com.wanglu.citystory.message.ErrorMessage;
import com.wanglu.citystory.service.IOAuthService;
import com.wanglu.citystory.service.IUserService;
import com.wanglu.citystory.util.OAuthGenerator;
import com.wanglu.citystory.util.WebContans;
import com.wangu.citystory.urls.AppURL;

@Controller
@RequestMapping(AppURL.APP_ROOT_URL)
public class UserController extends BaseController {

	@Resource
	IUserService userService;

	@Resource
	IOAuthService oauthService;

	/**
	 * 用户注册
	 * 
	 * @param mp
	 * @param jsonData
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(ModelMap mp, @RequestBody String jsonData
			) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			HashMap<String, String> mpJson = objectMapper.readValue(jsonData,
					new TypeReference<HashMap<String, String>>() {
					});

			String name = mpJson.get("name");
			String password = mpJson.get("password");
			Integer age = Integer.parseInt(mpJson.get("age"));

			if (name == null || password == null) {
				putError(mp, "用户名密码不能为空");
				return null;
			}

			User checkUser = userService.findUserByName(name);

			if (checkUser != null) {
				putError(mp, "用户名已存在");
				return null;
			}

			User user = new User();
			user.setAge(age);
			user.setPassword(password);
			user.setName(name);
			user.setId(UUID.randomUUID().toString());
			user.setRegistTime(System.currentTimeMillis());
			boolean addUserRes = userService.addUser(user);
			if (addUserRes) {
				OAuth oAuth = OAuthGenerator.generateOAuth(user.getId());
				boolean addOa = oauthService.addOAuth(oAuth);// 插入oauth
				if (addOa) {
					user.setoAuth(oAuth);
					putSuccess(mp, user);

				
				}

			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			putError(mp, ErrorMessage.CODE_FORMAT_ERROR);
		} catch (IOException e) {
			e.printStackTrace();
			putError(mp, ErrorMessage.CODE_FORMAT_ERROR);

		}

		return "regist";
	}

	@RequestMapping("/api/user/edit")
	public String apiTest(ModelMap modelMap,HttpServletRequest requst) {
		OAuth oa=(OAuth) requst.getAttribute(WebContans.OAUTH_REQUEST_KEY);
		modelMap.put("oa", oa);
		return "我操";

	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String appLogin(@RequestParam String name,
			@RequestParam String password, ModelMap modelMap,
			HttpSession httpSession, Exception e) {

		System.out.println(e.getMessage());

		if (!name.equals("") && !password.equals("")) {

			User checkUser = userService.findUserByName(name);
			if (checkUser != null && checkUser.getPassword().equals(password)) {

				OAuth oa = oauthService.findOauthByUserId(checkUser.getId());// 查找oa信息

				if (oa == null) {

					oa = OAuthGenerator.generateOAuth(checkUser.getId());
					oauthService.addOAuth(oa);

				}

				checkUser.setoAuth(oa);// 放入oa信息
				
				putSuccess(modelMap, checkUser);

			} else {

				putError(modelMap, "用户名密码不正确");
			}

		} else {

			putError(modelMap, "用户名密码不能为空");
		}

		return null;
	}

}
