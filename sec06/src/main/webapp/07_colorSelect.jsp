<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String[] movieList = {"어벤져스", "오펜하이머", "죠스", "스즈메의 문단속", "찰리와 초콜릿 공장", "007", "미션임파서블", "킬빌"};
pageContext.setAttribute("movieList", movieList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.color == 1 }">
	<h1 style="color:red;">빨강</h1>
</c:if>
<c:if test="${param.color == 2}">
	<h1 style="color:yellow;">노랑</h1>
</c:if>
<c:if test="${param.color == 3 }">
	<h1 style="color:blue;">파랑</h1>
</c:if>

<c:choose>
	<c:when test="${param.fruit == 1 }">
		<h1 style="color:red;">사과</h1>
	</c:when>
	<c:when test="${param.fruit == 2 }">
		<h1 style="color:yellow;">망고</h1>
	</c:when>
	<c:when test="${param.fruit == 3 }">
		<h1 style="color:green;">수박</h1>
	</c:when>	
</c:choose>

<hr>

<c:forEach var="item" items="${paramValues.item }" varStatus="status">
	${item } <c:if test="${not status.last }">, </c:if>
</c:forEach>

<hr>
<c:forEach var="movie" items="${movieList }" varStatus="status">
	${status.index }
	${status.count }
	${movie }<br>
</c:forEach>
</body>
</html>