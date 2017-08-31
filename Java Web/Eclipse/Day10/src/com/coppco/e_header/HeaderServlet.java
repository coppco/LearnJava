package com.coppco.e_header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取浏览器内核
		
		String agent = request.getHeader("user-agent");
		
		System.out.println("浏览器: " + agent);
		
		//获取referer
		String referer = request.getHeader("referer");
		
		if (null == referer) {
			System.out.println("地址栏输入!!");
		} else if (referer.contains("localhost")) {
			System.out.println("自己测试的");
		} else if (referer.contains("192.168.1.")) {
			System.out.println("内部测试");
		} else {
			
			System.out.println("盗链可耻!!");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
