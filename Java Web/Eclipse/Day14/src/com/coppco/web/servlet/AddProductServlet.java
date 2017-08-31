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
import com.coppco.utils.UUIDUtils;

/**
 * 添加商品
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		//获取令牌, 并进行对比
		String s_lingpai = (String) request.getSession().getAttribute("s_lingpai");
		String r_lingpai = request.getParameter("r_lingpai");
		//从session中移除
		request.getSession().removeAttribute("s_lingpai");
		
		if (!s_lingpai.equals(r_lingpai) || s_lingpai==null) {
			request.setAttribute("msg", "重复添加商品");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		
		//封装数据
		Product product = new Product();
		try {
			BeanUtils.populate(product, request.getParameterMap());
			
			//给商品设置pid 时间
			product.setPid(UUIDUtils.getId());
			product.setPdate(new Date());
			
			//调用service
			new ProductService().addProduct(product);
			
			//页面跳转-请求转发, 会出现表单提交问题
			//方法1: 使用重定向
			//方法2: 使用令牌机制
			request.getRequestDispatcher("/findAll").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("msg", "添加商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
