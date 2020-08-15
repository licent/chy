package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartResolver;

/**
 * 过滤器 验证是否登陆，未登陆的任何请求跳转至登录页
 * 
 * @author Taylor.O
 */
public class LoginFilter implements Filter {

	MultipartResolver multipartResolver;

	private List<String> alow_list = new ArrayList<String>();

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException {
		// 基于http协议的servlet
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			String url = req.getRequestURI();
			// 如果没有登录.
			//String requestURI = url.substring(url.indexOf("/"), url.length());
			// 不需要登录的请求页面过滤
			/*
			 * if (!alow_list.contains(requestURI)) {
				HttpSession session = req.getSession();
				UserDto userDto = (UserDto) session
						.getAttribute("USERSESSION");
				if (session == null || userDto == null) {
					res.sendRedirect(req.getContextPath() + "/login.html");
					// 返回
					return;
				}
			}
			*/
			chain.doFilter(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/login.html");
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//接口
		alow_list.add("/login.do");
		alow_list.add("/unlogin.do");
		
		//页面
		alow_list.add("/login.html");
	}

}
