<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span>forward 방식으로 이동된 페이지</span><br>
	<span>나이: <%= request.getParameter("age") %></span><br>
	<span>이름: <%= (String)request.getAttribute("name") %></span>
</body>
</html>