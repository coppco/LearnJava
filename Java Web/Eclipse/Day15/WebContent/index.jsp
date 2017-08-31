<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h2><a href="${pageContext.request.contextPath }/js_ajax/hello.jsp">原生AJAX</a></h2>
	
	<h2><a href="${pageContext.request.contextPath }/js_ajax/getRequest.jsp">get请求</a></h2>
	
	<h2><a href="${pageContext.request.contextPath }/js_ajax/postRequest.jsp">post请求</a></h2>
	
	<h2><a href="${pageContext.request.contextPath }/login.jsp">校验用户名是否存在</a></h2>
	
	<h1>jQuery中的AJAX</h1>
	<h2><a href="${pageContext.request.contextPath }/jQuery_ajax/ajax.jsp">常用方法</a></h2>
	
	<h2><a href="${pageContext.request.contextPath }/login2.jsp">jQuery的检验用户名是否存在</a></h2>
	
	<h2><a href="${pageContext.request.contextPath }/city.jsp">省市联动(动态)</a></h2>
	
	<h2><a href="${pageContext.request.contextPath }/helloFilter">测试filter</a></h2>
</body>
</html>