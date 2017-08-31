package com.coppco.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * get请求
 */
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		response.setContentType("text/html;charset=utf-8");
		// 获取参数
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8");

		// 回写
		response.getWriter().print("用户名: " + username + "\n" + "密码: " + password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 回写
		response.getWriter().print("用户名: " + username + "\n" + "密码: " + password);
	}

}
