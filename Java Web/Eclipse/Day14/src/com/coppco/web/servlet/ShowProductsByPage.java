package com.coppco.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coppco.domain.PageBean;
import com.coppco.domain.Product;
import com.coppco.service.ProductService;

/**
 * 分页展示商品
 */
public class ShowProductsByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = 3;
		
		//调用service
		PageBean<Product> bean;
		try {
			bean = new ProductService().showProductsByPage(currentPage, pageSize);
			//请求转发
			request.setAttribute("pb", bean);
			request.getRequestDispatcher("/product_page.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "出现错误");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
