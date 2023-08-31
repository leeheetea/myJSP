<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove</title>
</head>
<body>
	<h1>세션에 저장된 특정 객체 삭제하기</h1>
<%
session.setAttribute("s_name1", "저는 섹션에 저장된 첫번째 이름입니다");
session.setAttribute("s_name2", "저는 섹션에 저장된 두번째 이름입니다");
session.setAttribute("s_name3", "저는 섹션에 저장된 세번째 이름입니다");
%>
<h3>세션 값 삭제하기</h3>
<%
Enumeration names = session.getAttributeNames();
while(names.hasMoreElements()){
	String name = names.nextElement().toString();
	String value = session.getAttribute(name).toString();
	out.println(name + " : " + value + "<br>");
}

session.removeAttribute("s_name2");
out.println("<hr>");

names = session.getAttributeNames();
while(names.hasMoreElements()){
	String name = names.nextElement().toString();
	String value = session.getAttribute(name).toString();
	out.println(name + " : " + value + "<br>");
}

out.println("<hr>");
out.println("prev :" + request.isRequestedSessionIdValid());
session.invalidate();
out.println("after :" + request.isRequestedSessionIdValid());


%>
</body>
</html>