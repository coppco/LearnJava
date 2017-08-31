package com.coppco.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.service.AccountService;

/**
 * 
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		//post请求: 参数中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		//通用解决中文编码问题
//		new String(request.getParameter("formuser").getBytes("iso-8859-1"), "utf-8");
		
		//三个参数
		String fromuser = request.getParameter("fromuser");
		String touser = request.getParameter("touser");
		String amount = request.getParameter("amount");
		
		//调用accountService
		try {
			AccountService.account(fromuser, touser, amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			w.println("转账失败");
			return;
		}
		w.println("转账成功");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
