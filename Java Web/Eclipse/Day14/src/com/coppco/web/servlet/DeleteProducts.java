package com.coppco.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.service.ProductService;

/**
 * 删除多个
 */
public class DeleteProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String[] pids = request.getParameterValues("pid");
		
		//调用service
		try {
			new ProductService().deleteProducts(pids);
			request.getRequestDispatcher("/findAll").forward(request, response);
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "删除商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		//跳转
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
