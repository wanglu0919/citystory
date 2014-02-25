package com.wanglu.citystory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglu.citystory.entity.Admin;
import com.wanglu.citystory.util.StringTool;

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

	
	@RequestMapping(value="/ajaxLodin2",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap  ajaxLogin2(@RequestParam String username,@RequestParam String password,ModelMap mp,HttpSession httpSession){

		
		if (StringTool.isEmpty(username) && StringTool.isEmpty(password)) {
			if (username.equals("admin") && password.equals("admin")) {
				
				Admin admin=new Admin();
				admin.setName("admin");
				admin.setPassword("admin");
				
				httpSession.setAttribute(Admin.ADMIN_SESSION_KEY, admin);
				mp.put("url", "admin/main");
				mp.put("success", true);
				return mp;

			}else{
				mp.put("success", false);
				mp.put("msg", "用户名密码不正确 ");
				return mp;
			}

		} else {
			mp.put("success", false);
			mp.put("msg", "用户名密码不正确");
			return mp;

		}
		
		
		
	}
	
	
	
	@RequestMapping(value="/ajaxLogin",method=RequestMethod.POST)
	public void ajaxLogin(HttpServletRequest request,
			HttpServletResponse response) {

		String username = request.getParameter("username");
		String passwrod = request.getParameter("password");
		response.setContentType("text/xml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();

			if (StringTool.isEmpty(username) && StringTool.isEmpty(passwrod)) {
				if (username.equals("wanglu") && passwrod.equals("123456")) {
					pw.write("true");

				}else{
					pw.write("false");
				}

			} else {

				pw.write("false");

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
