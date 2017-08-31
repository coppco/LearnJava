package com.coppco.jquery.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jQuery的ajax
 */
public class JqueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("请求的方式: " + request.getMethod());
		//设置参数
		response.setContentType("html/text;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
		
		//接受参数
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		
		//响应数据
		response.getWriter().print("用户名: " + username + "\n密码: " + password + "\n请求方式: " + request.getMethod());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("请求的方式: " + request.getMethod());
		//设置参数
//		response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//接受参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//{"result": "success", "message": "成功!"}
		
		//json
		String s = "{\"result\": \"success\", \"message\": \"成功!\",\"username\": \"" + username + "\"}";
		
		//响应数据
		response.getWriter().print(s);
		
	}

}
