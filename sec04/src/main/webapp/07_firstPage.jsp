<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
pageContext.setAttribute("name", "page man");
request.setAttribute("name", "request man");
session.setAttribute("name", "session man");
application.setAttribute("name", "application man");
%>
<html>
<head>
<meta charset="UTF-8">
<title>First</title>
</head>
<body>
	firstPage.jsp :
	<br> 하나의 페이지 속성 :
	<%=pageContext.getAttribute("name")%><br> 하나의 요청 속성 :
	<%=request.getAttribute("name")%><br> 하나의 세션 속성 :
	<%=session.getAttribute("name")%><br> 하나의 애플리케이션 속성 :
	<%=application.getAttribute("name")%><br>
	<%
	request.getRequestDispatcher("./08_secoundPage.jsp").forward(request, response);
	%>

</body>
</html>