package com.coppco.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.coppco.bean.User;
import com.coppco.service.UserService;

/**
 * 注册
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码, 防止请求参数中文乱码, post请求可以直接下一句
		request.setCharacterEncoding("utf-8");
		
		//封装成User数据
		User user = new User();
		
		Map<String, String[]> paramMap = request.getParameterMap();
		
		try {
			BeanUtils.populate(user, paramMap);
			
			//调用UserService的注册方法
			int result = UserService.regist(user);
			
			if (result == 1) {
				request.setAttribute("msg", "注册成功");
			} else {
				request.setAttribute("msg", "注册失败");
			}
			request.getRequestDispatcher("/msg").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "出现错误");
			request.getRequestDispatcher("/msg").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
