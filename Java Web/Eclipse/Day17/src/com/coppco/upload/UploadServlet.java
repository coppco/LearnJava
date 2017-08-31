package com.coppco.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 上传文件
 */
@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		String username = request.getParameter("username");
		
		//f
		/*
		String f = request.getParameter("f");
		
		System.out.println(username + "::" + f);
		*/
		//获取上传的文件
		Part part = request.getPart("f");
		String fileName = part.getHeader("content-disposition").substring(part.getHeader("content-disposition").indexOf("filename=") + 10, part.getHeader("content-disposition").length() - 1);
		InputStream inputStream = part.getInputStream();
		
		//写文件
		FileOutputStream out = new FileOutputStream("/Users/apple/Desktop/" + fileName);
//		FileOutputStream out = new FileOutputStream(fileName);
		
//		System.out.println(this.getServletContext().getContextPath());
		
		int length = -1;
		byte[] arr = new byte[1024 * 8];
		while ((length = inputStream.read(arr)) != -1) {
			out.write(arr, 0, length);
		}
		out.close();
		inputStream.close();
		System.out.println("上传成功!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
