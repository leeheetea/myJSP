<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>Script let Example</h1>
<% 
	float f = 2.3f;
	int i = Math.round(f);
	java.util.Date date = new java.util.Date();
%>
<p>실수 f의 반올림 값은? <%= i%><p/>
현재의 날짜와 시간은? <%=date.toString()%>