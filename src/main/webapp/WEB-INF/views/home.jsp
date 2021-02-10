<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
body{

text-align: center;

}

</style>

</head>
<body>
<h1>
	Hello Spring_MVC_Board!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<img src = "resources/img/sesoko.png" width = 500px height = 300px><br/>

<img alt = "" src = "${pageContext.request.contextPath}/resources/img/sesoko.png"/>


<!-- http:localhost:8080/  resources 앞까지... ex를 뜻한다.-->




<a href = "board/list">게시판</a>

</body>
</html>
