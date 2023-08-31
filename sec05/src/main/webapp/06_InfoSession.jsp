<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InfoSession</title>
</head>
<body>
<%
String idString = session.getId();
Long lastTime = session.getLastAccessedTime();
Long createTime = session.getCreationTime();
Long timeUsed = (lastTime - createTime) / 60000;
int inActive = session.getMaxInactiveInterval() / 60;
boolean isNew = session.isNew();
%>
(1) 세션 ID는 [ <%= idString %>]<br>
(2) 세션의 마지막 access time [<%=lastTime %>]<br>
(3) 당신이 웹사이트에 머문 시간 [<%=timeUsed %>]<br>
(4) 세션의 유효시간은 [<%=inActive %>]<br>
(5) 세션이 새로 만들어 졌나요? [<%=isNew %>]<br>
</body>
</html>