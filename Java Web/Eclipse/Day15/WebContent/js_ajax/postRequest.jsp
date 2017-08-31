<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>post请求</title>
</head>
<body>
<input type="button" value="点我吧" onclick="btnClick()">
</body>
<script type="text/javascript">
	function btnClick() {
		//1、创建核心对象
		var xmlhttp = null;
		if (window.XMLHttpRequest) {// code for Firefox, Opera, IE7, etc.
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlhttp == null) {
			alert("你的浏览器版本太低, 请升级后重试!");
			return;
		}
		//2、设置回调函数
		xmlhttp.onreadystatechange = function(data) {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				alert(xmlhttp.responseText);
			}
		}
		//3、open, 设置请求方式和请求地址
		xmlhttp.open("post", "${pageContext.request.contextPath}/postServlet")
		
		//使用send发送请求时需要设置
		xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
		//4、send
		 xmlhttp.send("username=张三&password=123456");
	}
</script>

</html>