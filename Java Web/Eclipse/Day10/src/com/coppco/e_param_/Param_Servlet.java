package com.coppco.e_param_;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Param_Servlet
 */
public class Param_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("username: " + request.getParameter("username"));
		System.out.println("password: " + request.getParameter("password"));
		
		
		System.out.println("username: " + new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8"));
		System.out.println("password: " + new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8"));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("username: " + request.getParameter("username"));
		System.out.println("password: " + request.getParameter("password"));
	}

}
