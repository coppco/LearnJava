package com.coppco.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.coppco.domain.Product;
import com.coppco.service.ProductService;

/**
 * 修改商品
 */
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		//封装数据
		Product product = new Product();
		try {
			BeanUtils.populate(product, request.getParameterMap());
			
			//给商品设置时间
			product.setPdate(new Date());
			
			//调用service
			new ProductService().editProduct(product);
			
			//页面跳转-请求转发, 会出现表单提交问题
			//方法1: 使用重定向
			//方法2: 使用令牌机制
			request.getRequestDispatcher("/findAll").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("msg", "修改商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
