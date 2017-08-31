<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//数组
	request.setAttribute("arr", new int[] {1,2,3,4,5});
	
	//list
	ArrayList<String> list = new ArrayList<String>();
	list.add("a");
	list.add("bb");
	list.add("ccc");
	request.setAttribute("list", list);
	
	//map
	
	Map map = new HashMap();
	map.put("a","a");
	map.put("b","b");
	map.put("c","c");
	request.setAttribute("map", map);
	%>
	<h2>数组</h2>>
	老方式获取数据: <br/>
	<%=
	((int[])request.getAttribute("arr"))[1]
	%>
	<br/>
	
	el获取复杂数据<br/>
	${arr[1]}
	
	<h2>list</h2>>
	老方式获取数据: <br/>
	<%=
	((ArrayList)request.getAttribute("list")).get(1)
	%>
	<br/>
	
	el获取复杂数据<br/>
	${list[1]}
	
	<h2>map</h2>>
	老方式获取数据: <br/>
	<%=
	((Map)request.getAttribute("map")).get("a")
	%>
	<br/>
	
	el获取复杂数据<br/>
	${map.a}
	
</body>
</html>