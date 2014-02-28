package com.wanglu.citystory.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wanglu.citystory.entity.Admin;

/**
 * 管理员权限拦截器
 * 
 * @author wanglu
 * 
 */
public class AdminConsoleAuthorityInceptor implements HandlerInterceptor {

	private Logger logger = Logger
			.getLogger(AdminConsoleAuthorityInceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {

		HttpSession httpSession = request.getSession();
		Admin admin = (Admin) httpSession.getAttribute(Admin.ADMIN_SESSION_KEY);// 查看用户有没有登录
		if (admin == null) {
			
			response.sendRedirect("../login");

			return false;

		} else {

			return true;
		}

	}

}
