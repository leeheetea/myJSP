<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get</title>
</head>
<body>
<%
String id = (String)session.getAttribute("id");
String password = (String)session.getAttribute("pwd");
Integer age = (Integer)session.getAttribute("age");
%>

id : <%=id %> <br>
password : <%=password %> <br>
age : <%=age %> <br>

<h1>이름과 세션값 가져오기</h1>
<%
Enumeration names = session.getAttributeNames();
while(names.hasMoreElements()){
	String name = names.nextElement().toString();
	String value = session.getAttribute(name).toString();
	out.println(name + " : " + value + "<br>");
}
%>
</body>
</html>