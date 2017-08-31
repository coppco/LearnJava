package com.coppco.c_download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String fileName = request.getParameter("name");
		fileName = new String(fileName.getBytes("iso8859-1"), "utf-8");
		//获取mime类型,并设置
		ServletContext servletContext = this.getServletContext();
		String type = servletContext.getMimeType(fileName);
		response.setContentType(type);
		//设置头信息
	
//		response.setHeader("content-disposition", "attachment;filename=" + fileName);

		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
		
		//获取输入流
		InputStream resourceAsStream = servletContext.getResourceAsStream("/download/" + fileName);
		
		//获取输出了
		ServletOutputStream outputStream = response.getOutputStream();
		
		byte[] arr = new byte[1024 * 8];
		int length = -1;
		while ((length = resourceAsStream.read(arr)) != -1) {
			outputStream.write(arr, 0, length);
		}
		
		outputStream.close();
		resourceAsStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
