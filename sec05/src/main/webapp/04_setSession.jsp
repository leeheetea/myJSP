<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.setAttribute("id", "keduit");
session.setAttribute("pwd", "test1234");
session.setAttribute("age", 20);
%>
<a href="05_getSession.jsp">get으로 갑니다</a>
</body>
</html>