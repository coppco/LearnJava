<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2017/9/6
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>完全解耦合</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/regest_*.action" method="post">
    姓名: <input type="text" name="username" /> <br />
    密码: <input type="password" name="password" /> <br />
    <input type="submit" value="注册">
</form>
</body>
</html>
