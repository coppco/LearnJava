<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有商品</title>
<style type="text/css">
table {
	border: 1px solid purple;
	margin: auto;
	text-align: center;
	width: 100%;
}

tr, th, td {
	border: 1px solid purple;
}
</style>
</head>
<body>

	<table>
		<tr>
			<td colspan="7">
			<form action="${pageContext.request.contextPath }/findproductByCondition" method="post">
				商品名称: <input type="text" name="name">
				&nbsp;
				&nbsp;
				关键字: <input type="text" name="key">
				&nbsp;
				&nbsp;
				<input type="submit" value="搜索">
			</form>
			</td>
			<td colspan="1" align="right"><input type="button" value="删除选中"
				onclick="deleteClick()"></td>
			<td></td>
		</tr>
		<tr>
			<th><input type="checkbox" onclick="selectedAll(this)" /></th>
			<th>pid</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>
			<th>日期</th>
			<th>操作</th>
		</tr>

		<!-- 遍历 -->
		<form id="formId" action="${pageContext.request.contextPath }/deleteProducts" method="post">
			<c:forEach items="${list }" var="p">
				<tr>
					<td width='2%'><input type="checkbox" name="pid"
						value="${p.pid }" /></td>
					<td width='8%'>${p.pid }</td>
					<td width='8%'><img
						src="${pageContext.request.contextPath }/${p.pimage }" alt="商品名" /></td>
					<td width='8%'>${p.pname }</td>
					<td width='8%'>${p.market_price }</td>
					<td width='8%'>${p.shop_price }</td>
					<td>${p.pdesc }</td>
					<td width='8%'>${p.pdate }</td>
					<td width='10%'><a
						href="${pageContext.request.contextPath }/getProductById?pid=${p.pid}">修改</a>|<a
						href="${pageContext.request.contextPath }/deleteProduct?pid=${p.pid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</form>
	</table>

</body>
<script type="text/javascript">
	//全选or全不选
	function selectedAll(obj) {
		//获取所有的复选框
		var arr = document.getElementsByName("pid");

		//遍历数组
		for (var i = 0; i < arr.length; i++) {
			arr[i].checked = obj.checked;
		}
	}

	//删除选中
	function deleteClick() {
		document.getElementById("formId").submit();
	}
</script>
</html>