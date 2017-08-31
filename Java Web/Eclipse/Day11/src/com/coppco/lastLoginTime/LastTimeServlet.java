package com.coppco.lastLoginTime;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 最后登录时间
 */
public class LastTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		response.setContentType("text/html;charset=utf-8");
		
		//获取Cookie
		Cookie cookie = getCookieByName("lastTime", request.getCookies());
		
		if (null == cookie) {
			response.getWriter().print("你是第一次访问!");
		} else {
			Date date = new Date(Long.parseLong(cookie.getValue()));
			response.getWriter().print("你上次访问时间是: " + date.toLocaleString());
		}
	
		//创建Cookie
		//获取当前时间戳
//		System.currentTimeMillis()
//		new Date().getTime()
		cookie = new Cookie("lastTime", new Date().getTime() + "");
		//设置过期时间
		cookie.setMaxAge(24 * 60 * 60);
		//路径
		cookie.setPath(request.getContextPath() + "/");
		//写回浏览器
		response.addCookie(cookie);
	}

	private Cookie getCookieByName(String name, Cookie[] cookies) {
		if (null == cookies) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
