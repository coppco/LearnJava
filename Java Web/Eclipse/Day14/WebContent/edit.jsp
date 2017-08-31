<%@page import="com.coppco.utils.UUIDUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
<style type="text/css">
table {
	border: 1px solid purple;
	text-align: center;
	margin: auto;
	width: 50%;
}
</style>
</head>
<body>

	<form action="${pageContext.request.contextPath }/editProduct"
		method="post">
		<input name="pid" type="hidden" value="${beanProduct.pid }">
		<table>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname" value="${beanProduct.pname }"></td>
			</tr>

			<tr>
				<td>市场价</td>
				<td><input type="text" name="market_price" value="${beanProduct.market_price }"></td>
			</tr>

			<tr>
				<td>商城价</td>
				<td><input type="text" name="shop_price" value="${beanProduct.shop_price }"></td>
			</tr>

			<tr>
				<td>商品描述</td>
				<td><input type="text" name="pdesc" value="${beanProduct.pdesc }"></td>
			</tr>

			<tr>
				<td colspan=2><input type="submit" name="" value='修改'></td>
			</tr>
		</table>

	</form>

</body>
</html>