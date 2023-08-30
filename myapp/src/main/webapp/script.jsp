<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP 스크립트</title>
</head>
<body>
 <h1>Script Example</h1>
<%!
	String declaration = "Declaration";
%>
<%!
	public String decMethod(){
	return declaration;
	}
%>
<%
	String scriptlet = "Scriptlet";
	String comment = "Comment";
	out.println("내장객체를 이용한 출력 : " + declaration + "<p>");
%>
선언문의 출력1: <%=declaration %>
선언문의 출력2: <%=decMethod() %>
스크립트릿의 출력 : <%=scriptlet %>

<!-- 주석 -->

</body>
</html>