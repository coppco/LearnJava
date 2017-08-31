package com.coppco.e_param;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

/**
 * 获取请求参数
 */
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String name = request.getParameter("username");
		
		System.out.println("用户名: " + name);
		
		//
		String[] parameterValues = request.getParameterValues("password");
		System.out.println("密码: " + Arrays.toString(parameterValues));
		
		//获取所有参数和值
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		for (Map.Entry<String, String[]> value : parameterMap.entrySet()) {
			System.out.println(value.getKey() + ":" + Arrays.toString(value.getValue()));
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
