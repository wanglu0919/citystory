package com.wanglu.citystory.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wanglu.citystory.entity.OAuth;
import com.wanglu.citystory.service.IOAuthService;

/**
 * 管理员权限拦截器
 * 
 * @author wanglu
 * 
 */
public class AppApiInceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(AppApiInceptor.class);

	@Resource
	IOAuthService oauthService;

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

		String accessToken = request.getParameter("accessToken");

		if (accessToken == null) {
			response.getWriter().write("accessToken is null");

			return false;
		} else {

			OAuth oAuth = (OAuth) request.getSession()
					.getAttribute(accessToken);

			boolean valideate = true;
			if (oAuth == null) {
				OAuth oa = oauthService.findOAuthByAccessToken(accessToken);// 查询数据库

				if (oa != null) {
					request.getSession().setAttribute(accessToken, oa);

				} else {
					response.getWriter().write("accessToken is error");
					valideate = false;
				}

			}

			return valideate;
		}

	}

}
