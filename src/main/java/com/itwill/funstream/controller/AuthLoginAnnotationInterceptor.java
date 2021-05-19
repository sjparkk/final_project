package com.itwill.funstream.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itwill.funstream.domain.UserInfo;

public class AuthLoginAnnotationInterceptor extends HandlerInterceptorAdapter {

	public AuthLoginAnnotationInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod == false) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		LoginCheck loginCheck = handlerMethod.getMethodAnnotation(LoginCheck.class);

		HttpSession session = request.getSession();
		UserInfo sUser = (UserInfo) session.getAttribute("sUser");

		if (loginCheck == null) {
			if (sUser != null && request.getRequestURI().contains("user_login_form")) {
				response.sendRedirect("index");
				return false;
			}
			return true;
		}

		if (sUser == null) {
			response.sendRedirect("user_login_form?uri=" + request.getRequestURI().split("/")[2]);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}