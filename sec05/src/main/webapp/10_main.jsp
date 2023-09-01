<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<%

if(session.getAttribute("loginUser") == null){
	response.sendRedirect("08_loginForm.jsp");
} else {
%>
<%= session.getAttribute("loginUser") %> 님 안녕하세요. <br>
<form method="POST" action="11_logout.jsp">
	<input type="submit" value="logout">
</form>

<%
}
%>
</body>
</html>