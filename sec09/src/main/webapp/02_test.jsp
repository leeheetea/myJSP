<%@page import="java.sql.Connection"%>
<%@page import="com.keduit.dao.MemberDAO"%>
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
MemberDAO memberDAO = MemberDAO.getInstacnce();
Connection conn = memberDAO.getConnection();
out.println("db connect success");
%>
</body>
</html>