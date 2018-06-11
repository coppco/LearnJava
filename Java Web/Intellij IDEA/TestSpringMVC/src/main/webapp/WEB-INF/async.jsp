<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Async support</title>
</head>

<body id="aaa">
<script type="text/javascript" src="js/jquery-1.6.4.js"></script>
<script type="text/javascript">
    deferred();
    function deferred() {
        $.get('defer', function (data) {
            console.log(data);

            $("#aaa")
            deferred();
        })
    }
</script>
${message}
</body>
</html>