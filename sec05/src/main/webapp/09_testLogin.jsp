<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Login</title>
</head>
<body>
<%
String id="kedu";
String pwd="1234";
String name="한정교";

if(request.getParameter("id").equals(id) && request.getParameter("password").equals(pwd)){
	session.setAttribute("loginUser", name);
	response.sendRedirect("10_main.jsp");
} else{
	response.sendRedirect("08_loginForm.jsp");
}
%>
</body>
</html>