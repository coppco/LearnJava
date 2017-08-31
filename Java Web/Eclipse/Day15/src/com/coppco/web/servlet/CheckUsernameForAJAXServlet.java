package com.coppco.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.domain.User;
import com.coppco.service.UserService;

/**
 * 检查用户名是否存在
 */
public class CheckUsernameForAJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/test;charset=utf-8");
		
		//获取参数
		String username = request.getParameter("username");
		
		//调用service
		User user = null;
		try {
			user = new UserService().findUserForUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//回写
		if (null == user) {
			response.getWriter().print("1");
		} else {
			response.getWriter().print("0");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
