package com.wanglu.citystory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wanglu.citystory.entity.Admin;

/**
 * 
 * @author 王璐 后台管理功能
 * 
 */

@Controller
public class LoginController {

	/**
	 * @author wanglu
	 * @param httpSession
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpSession httpSession) {
		httpSession.removeAttribute(Admin.ADMIN_SESSION_KEY);
		return "login";

	}

	@RequestMapping("/logout")
	public String loginOut(HttpSession httpSession) {
		httpSession.removeAttribute(Admin.ADMIN_SESSION_KEY);

		return "login";
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute Admin admin, HttpSession httpSession) {

		if ((admin.getName() != null && admin.getName().equals("wanglu"))
				&& (admin.getPassword() != null && admin.getPassword().equals(
						"12"))) {
			httpSession.setAttribute(Admin.ADMIN_SESSION_KEY, admin);
			return "main";
		} else {

			return "login";
		}

	}

}
