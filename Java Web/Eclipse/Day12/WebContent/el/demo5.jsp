<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- <%@ taglib prefix="c" uri="" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%=request.getContextPath()
	%><br/>
	
	<c:if test="${3>4}">
	3大于4
	</c:if>
	<br/>
	<c:if test="${3<=4}">
	3小于等于4
	</c:if>
</body>
</html>