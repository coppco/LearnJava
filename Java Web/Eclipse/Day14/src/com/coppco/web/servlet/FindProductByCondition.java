package com.coppco.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.domain.Product;
import com.coppco.service.ProductService;

/**
 * 多条件查询
 */
public class FindProductByCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String key = request.getParameter("key");
		
		//调用service
		List<Product> list = null;
		try {
			list = new ProductService().findProductByCondition(name, key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//页面跳转
		//放到request中
		
		request.setAttribute("list", list);
				
		//请求转发
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
