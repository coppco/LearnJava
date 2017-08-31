<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市联动</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	//页面加载完成之后
	$(function() {
		$.ajax({
 			type : "post",
			url : "${pageContext.request.contextPath}/selectPro",
			data : "",
			dataType : "json",
			success : function(data) {
 				var $pro = $("#proID");
				$(data).each(function() {
					$pro.append($("<option value=" + this.provinceid + ">"+ this.name + "</option>"));
				});
			},
			error : function(xml, message, e) {
				alert(e);				}
			});
	});
</script>
</head>
<body>
	<center>
		<select id="proID" name="province">
			<option>-省份-</option>
		</select> <select id="cityID" name="city">
			<option>-请选择-</option>
		</select>
	</center>
</body>
<script type="text/javascript">
	//下拉选派发事件
	$("#proID").change(function() {
		//省份id
		var pid = $(this).val();
		
		//ajax请求
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath}/selectCityByProvinceid",
			dataType: "json",
			data: {"pid": pid},
			success: function(data) {
				var $city = $("#cityID");
					$city.empty();
				$(data).each(function() {
					$city.append($("<option value=" + this.cityid + ">"+ this.name + "</option>"));
				});
			},
			error: function(xml, message, e) {
				
			}
		});
		
	});
</script>
</html>