<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP ��ũ��Ʈ</title>
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
	out.println("���尴ü�� �̿��� ��� : " + declaration + "<p>");
%>
������ ���1: <%=declaration %>
������ ���2: <%=decMethod() %>
��ũ��Ʈ���� ��� : <%=scriptlet %>

<!-- �ּ� -->

</body>
</html>