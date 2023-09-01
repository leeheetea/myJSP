<%@page import="com.keduit.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="msg" value="Hello"></c:set>
\${msg}= ${msg}<br>

<c:set var="age" value="30"></c:set>
age = ${age}<br>

<c:set var="member" value="<%= new MemberBean() %>"></c:set>
<c:set target="${member}" property="name" value="한정교"></c:set>
<c:set target="${member}" property="userId">keduit</c:set>

\${member} = ${member }<br>
\member.userId = ${member.userId }

<hr>
<c:set var="add" value="${10+5 }"></c:set>
<c:set var="flag" value="${10 > 5 }"></c:set>

\${add} = ${add } <br>
\${flag} = ${flag }

</body>
</html>