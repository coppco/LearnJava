package com.coppco.e_request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet01
 */
public class RequestServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求方式
		String method = request.getMethod();
		System.out.println("请求方法: " + method);
		
		//获取项目名
		String projectName = request.getContextPath();
		System.out.println("项目名称: : " + projectName);
		
		//获取请求者IP
		String remoteAddr = request.getRemoteAddr();
		System.out.println("请求者IP: "  + remoteAddr);
		
		//获取请求资源
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
	
		System.out.println("URI: " + requestURI);
		System.out.println("URL: " + requestURL);
		
		//请求参数
		String queryString = request.getQueryString();
		System.out.println("请求参数: " + queryString);
		
		//获取协议
		String protocol = request.getProtocol();
		System.out.println("协议: " + protocol);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
