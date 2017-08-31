package com.coppco.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 商品浏览记录
 */
public class GetProductByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置content-type
		response.setContentType("text/html;charset=utf-8");
		
		//获取参数
		String ID = request.getParameter("ID");
		
		//获取指定Cookie
		Cookie idCookie = getCookieByName("IDS", request.getCookies());

		String IDS = "";
		//判断Cookie是否为空
		if (null == idCookie) {
			//空
			IDS = ID;
		} else {
			
			IDS = idCookie.getValue();
			LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(IDS.split("-")));
			//判断是否包含该ID值
			if (linkedList.contains(ID)) {
				//包含ID
				linkedList.remove(ID);
//				linkedList.add(0, ID);
				linkedList.addFirst(ID);
			} else {
				//判断长度是否大于3
				if (linkedList.size() >= 3) {
					linkedList.removeLast();
					linkedList.addFirst(ID);
				} else {
					linkedList.addFirst(ID);
				}
			}
			IDS = "";
			for (String s : linkedList) {
				IDS += (s + "-");
			}
			IDS = IDS.substring(0, IDS.length() - 1);
		}
		
		//修改Cookie
		idCookie = new Cookie("IDS", IDS);
		//设置访问路径
		idCookie.setPath(request.getContextPath() + "/");
		//设置存活时间
		idCookie.setMaxAge(24 * 3600);
		//将Cookie发送到浏览器
		response.addCookie(idCookie);
		//跳转到指定页面
		response.sendRedirect(request.getContextPath() + "/product_info" + ID + ".html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 从cookie中查找指定的cookie
	 * @param name
	 * @param cookies
	 * @return
	 */
	private Cookie getCookieByName(String name, Cookie[] cookies) {
		if (null == cookies) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}
}
