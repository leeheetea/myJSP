<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>클라이언트가 응답한 쿠키</h1>
<%
Cookie[] cookies = request.getCookies();
for(Cookie c : cookies) {
	out.println(c.getName() + " : " + c.getValue() + "<br>");
}
%>
<h1>쿠키 설정</h1>
</body>
</html>