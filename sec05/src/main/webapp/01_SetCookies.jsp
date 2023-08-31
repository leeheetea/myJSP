<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Cookies</title>
</head>
<body>
<h1>쿠키 설정</h1>
<%
Cookie cookie = new Cookie("id", "keduit");
cookie.setMaxAge(365*24*60*60);
response.addCookie(cookie);
response.addCookie(new Cookie("pwd","test1234"));
response.addCookie(new Cookie("age", "20"));
%>
<a href="02_getCookies.jsp">쿠키 확인</a>
</body>
</html>