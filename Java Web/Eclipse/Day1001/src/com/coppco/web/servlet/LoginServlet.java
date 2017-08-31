package com.coppco.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.bean.User;
import com.coppco.service.UserService;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//查询数据库
		User user = null;
		try {
			user = UserService.getUserByNameAndPassword(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (null == user) {
			response.getWriter().print("用户名或者密码不匹配!");
			response.addHeader("refresh", "3;url=/Day1001/login.htm");
		} else {
			response.getWriter().print(user.getUsername() + ": 欢迎回家!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
