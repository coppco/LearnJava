<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setAttribute("rkey", "rvalue");
	session.setAttribute("skey", "svalue");
	application.setAttribute("akey", "avalue");
	%>
	
	方式1: 获取数据<br/>
	<%=request.getAttribute("rkey")
	%><br/>
	方式2: 通过el获取数据<br/>
	${requestScope.rkey}<br/>
</body>
</html>