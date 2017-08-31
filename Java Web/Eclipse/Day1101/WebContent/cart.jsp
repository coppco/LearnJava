<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" align="cetner" width="30%">
		<tr>
			<td>商品名称</td>
			<td>商品数量</td>
		</tr>
			
			<%
			//获取购物车
			Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("cart");
			
			if(null == cart) {
				out.print("<tr><td colspan='2'>亲, 购物车空空如也~~</td></tr>");
			} else {
				for(String name : cart.keySet()) {
					out.print("<tr>");
					out.print("<td>");
					out.print(name);
					out.print("</td>");
					out.print("<td>");
					out.print(cart.get(name));
					out.print("</td>");
					out.print("</tr>");
				}
			}
			%>
	</table>
	<hr />
	<a href="/Day1101/product_list.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;
	<br/ >
	<a href="/Day1101/clearCart">清空购物车</a>&nbsp;&nbsp;&nbsp;
</body>
</html>