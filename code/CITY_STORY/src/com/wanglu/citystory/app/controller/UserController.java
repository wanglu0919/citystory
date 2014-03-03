package com.wanglu.citystory.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.catalina.util.MD5Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanglu.citystory.entity.User;
import com.wanglu.citystory.message.ErrorMessage;
import com.wanglu.citystory.service.IUserService;
import com.wanglu.citystory.util.Md5Util;
import com.wangu.citystory.urls.AppURL;

@Controller
@RequestMapping(AppURL.APP_ROOT_URL)
public class UserController extends BaseController {

	@Resource
	IUserService userService;

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(ModelMap mp, @RequestBody String jsonData) {

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
			user.setAccessToken(Md5Util.md5(UUID.randomUUID().toString()));
			user.setRegistTime(System.currentTimeMillis());
			user.setTokenUpdatetTime(System.currentTimeMillis());
			boolean addUserRes = userService.addUser(user);
			if (addUserRes) {
				putSuccess(mp, user);
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
	
	
	
}
