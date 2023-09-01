<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%! 
	Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "tiger";
	String sql = "insert into member values (?, ?, ?, ?, ?, ?)";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Member</title>
</head>
<body>
<%
 request.setCharacterEncoding("UTF-8");
 String name = request.getParameter("name");
 String userId = request.getParameter("userId");
 String pwd = request.getParameter("pwd");
 String email = request.getParameter("email");
 String phone = request.getParameter("phone");
 int admin = Integer.parseInt(request.getParameter("admin"));
 
 try{
	 Class.forName("oracle.jdbc.OracleDriver");
	 conn = DriverManager.getConnection(url, uid, pass);
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1, name);
	 pstmt.setString(2, userId);
	 pstmt.setString(3, pwd);
	 pstmt.setString(4, email);
	 pstmt.setString(5, phone);
	 pstmt.setInt(6, admin);
	 
	 pstmt.executeUpdate();
 } catch (Exception error) {
	 error.printStackTrace();
 } finally {
	 try {
	 if(pstmt != null){
		 pstmt.close();
	 } if(conn != null){
		 conn.close();
	 }} catch (Exception error){
		 error.printStackTrace();
	 }
 }
%>

<h3>회원 가입 성공</h3>
<a href="03_MemberList">회원 목록 보기</a>
	
</body>
</html>