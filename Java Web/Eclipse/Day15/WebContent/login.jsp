<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>检验用户名是否存在</title>
<style type="text/css">
table {
	
	margin: auto;
	text-align: ceter;

}

tr, th, td {

	text-align: center;
}
</style>
</head>
<body>

	<form action="#" method="post">

		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"
					onblur="checkUsername(this)"></td>
				<td><span id="usernameMsg"></span></td>
			</tr>

			<tr>
				<td>密码:</td>
				<td><input type="text" name="password"></td>
				<td><span id="passwordMsg"></span></td>
			</tr>

			<tr>
				<td colspan=3><input id="submitB" type="submit" name="password" value="注册">
				</td>
			</tr>

		</table>

	</form>

</body>
<script type="text/javascript">
	function checkUsername(obj) {
		if (obj.value == null || obj.value.length == 0) {
			alert("用户名不能为空");
		} else {
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
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
					if (xmlhttp.responseText == 1) {
						document.getElementById("usernameMsg").innerHTML = "<font color='green'>用户名可以使用</font>";
						document.getElementById("submitB").disabled = false;
					} else if (xmlhttp.responseText == 0) {
						document.getElementById("usernameMsg").innerHTML = "<font color='red'>用户名已被占用</font>";
						document.getElementById("submitB").disabled = true;
					}
				}
			}
			
			//3、设置请求方式和url
			xmlhttp.open("post", "${pageContext.request.contextPath}/checkUsername");
			
			//设置请求头
			xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
			
			//4、发送请求
			xmlhttp.send("username=" + obj.value);
		}
	}
</script>
</html>