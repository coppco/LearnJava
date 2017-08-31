<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>检验用户名是否存在</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
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
				<td><input id="username" type="text" name="username"></td>
				<td><span id="usernameMsg"></span></td>
			</tr>

			<tr>
				<td>密码:</td>
				<td><input type="text" name="password"></td>
				<td><span id="passwordMsg"></span></td>
			</tr>

			<tr>
				<td colspan=3><input id="submitB" type="submit" name="password"
					value="注册"></td>
			</tr>

		</table>

	</form>

</body>
<script type="text/javascript">
	$(function() {
		$("input[name='username']").blur(function() {
			//获取输入值
			var $value = $(this).val();
			if ($value != null && $value.length > 0) {
				$.ajax({
					url: "${pageContext.request.contextPath}/checkUsername",
					type: "POST",
					data: {"username": $value},
					dataType: "text",
					success: function(data) {
						if (data == 1) {
							$("#usernameMsg").html("<font color='green'>用户名可以使用</font>");
						} else if(data == 0) {
							$("#usernameMsg").html("<font color='red'>用户名已被使用</font>");
						}
					},
					error: function(xmlReques, message, e) {
						alert(message);
					}
				});
			}
		});
	});
</script>
</html>