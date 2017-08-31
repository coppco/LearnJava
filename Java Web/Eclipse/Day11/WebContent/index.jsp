<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	
	测试使用Java代码书写
	
	<%
		int i = 10;
		i++;
	%>
	<br />
	<%=
	i
	%>
	
		<%-- out是内置对象 --%>
	<%
		out.print("123");
	%>
	<br/>
	
	<a href="/Day11_JSP/hello">a_Cookie_Hello</a>
		<br/>
	
	<a href="/Day11_JSP/lastTime">上次访问时间</a>
	
</body>
</html>