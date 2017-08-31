package com.coppco.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 添加购物车
 */
public class Add2CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//获取请求参数, 需要解决中文乱码
		//request.setCharacterEncoding("utf-8"); //post请求才会有作用
		
		//通用设置
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		if (name.isEmpty()) {
			return;
		}
		//将商品添加到购物车
		//获取购物车
		Integer count = 0;
		Map<String, Integer> cart = (Map<String, Integer>) request.getSession().getAttribute("cart");

		if (null == cart) {
			cart = new HashMap<>();
			count = 1;
			
			request.getSession().setAttribute("cart", cart);
		} else {
			if (cart.containsKey(name)) {
				count = cart.get(name) + 1;
			} else {
				count = 1;
			}
		}
		cart.put(name, count);
		
		response.getWriter().print("已将<b>" + name + "</b>添加进购物车!</hr>");
		response.getWriter().print("<a href=" + request.getContextPath() + "/product_list.jsp" + ">继续购物</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		response.getWriter().print("<a href=" + request.getContextPath() + "/cart.jsp" + ">查看购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
