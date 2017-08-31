<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页展示</title>
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
			<th>pid</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>
			<th>日期</th>
		</tr>

		<!-- 遍历 -->
		<c:forEach items="${pb.list }" var="p">
			<tr>
				<td width='8%'>${p.pid }</td>
				<td width='8%'><img
					src="${pageContext.request.contextPath }/${p.pimage }" alt="商品名" /></td>
				<td width='8%'>${p.pname }</td>
				<td width='8%'>${p.market_price }</td>
				<td width='8%'>${p.shop_price }</td>
				<td>${p.pdesc }</td>
				<td width='8%'>${p.pdate }</td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<!-- 第一页 不展示首页和上一页 -->
		<c:if test="${pb.currentPage != 1 }">
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currentPage=1">[首页]</a>
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currentPage=${pb.currentPage - 1}">[上一页]</a>
		</c:if>

		<!-- 展示页面 -->
		<c:forEach begin="1" end="${pb.totalPage }" var="n">
			<c:if test="${pb.currentPage != n}">
				<a
					href="${pageContext.request.contextPath }/showProductsByPage?currentPage=${n}">${n }</a>
			</c:if>
			<c:if test="${pb.currentPage == n}">
				${n }
			</c:if>
		</c:forEach>
 
		<!-- 最后一页 不展示尾页和上一页 -->
		<c:if test="${pb.currentPage != pb.totalPage }">
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currentPage=${pb.currentPage + 1}">[下一页]</a>
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currentPage=${pb.totalPage  }">[尾页]</a>
		</c:if>
		<br /> 当前第${pb.currentPage }页/总共${pb.totalPage }页
	</center>
</body>
</html>