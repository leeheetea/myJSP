<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>Script let Example</h1>
<% 
	float f = 2.3f;
	int i = Math.round(f);
	java.util.Date date = new java.util.Date();
%>
<p>�Ǽ� f�� �ݿø� ����? <%= i%><p/>
������ ��¥�� �ð���? <%=date.toString()%>