<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove</title>
</head>
<body>
<%
Cookie cookie = new Cookie("id", "");
Cookie cookie2 = new Cookie("pwd", "");
Cookie cookie3 = new Cookie("age", "");
cookie.setMaxAge(0);
cookie2.setMaxAge(0);
cookie3.setMaxAge(0);
response.addCookie(cookie);
response.addCookie(cookie2);
response.addCookie(cookie3);
%>

<h1>쿠키를 삭제합니다!</h1>
<a href="02_getCookies.jsp">삭제 후 쿠키확인</a>
</body>
</html>