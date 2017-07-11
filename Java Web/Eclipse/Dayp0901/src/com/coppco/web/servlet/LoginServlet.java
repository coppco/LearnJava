package com.coppco.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.bean.User;
import com.coppco.service.UserService;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("count", 0);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		resp.setContentType("text/html;charset=utf-8");
		
		//获取参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		

		try {
			User user = UserService.getUserByUsernameAndPassword(username, password);
			if (null == user) {
				resp.getWriter().print("用户名或者密码不匹配!");
				resp.addHeader("refresh", "3;url=/Day0901/login.htm");
			} else {
				resp.getWriter().print(user.getUsername() + ": 欢迎回家!");
				ServletContext servletContext = this.getServletContext();
				servletContext.setAttribute("count", (Integer)servletContext.getAttribute("count") + 1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
