package com.coppco.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.domain.Product;
import com.coppco.service.ProductService;

/**
 * 通过pid查询商品
 */
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		
		//获取商品pid
		String pid = request.getParameter("pid");
		Product product;
		try {
			product = new ProductService().getProductById(pid);
			if (null == product) {
				request.setAttribute("msg", "无法查到到该商品");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			} else {
				//跳转页面, 请求转发
				request.setAttribute("beanProduct", product);
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			request.setAttribute("msg", "无法查到到该商品");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
