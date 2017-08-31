<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery中的AJAX</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").click(function() {
			var url = "${pageContext.request.contextPath }/jqueryAjax";
			var params = {"username": "张三","password": "123456"};
			
			//load方法
			/*
			$(this).load(url, params, function(d) {
				alert(d);
			});
			*/
			
			//get方法
			/*
			$.get(url, params, function(d) {
				alert(d);
			}, "text");
			*/
			
			//post方法
			/*
			$.post(url, params, function(d) {
				alert(d.message);
			}, "json");
			*/
			
			//如果需要处理失败的情况需要使用
			$.ajax({
				url:url, //请求的url
				type: "post", //请求方式
				dataType: "json", //返回数据类型
				data: params, //请求参数
				async: false, //是否异步
				success: function(data) { //成功回调
					alert(data.result + data.message + data.username);
				},
				error: function(xml,error, e) { //失败回调
					alert(xml + error + e);
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="button" id="btn1" value="点我吧" />
</body>
</html>