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
	<c:if test="${param.color == 1 }">
		<h1 style="color: red;">빨강</h1>
	</c:if>
	<c:if test="${param.color == 2 }">
		<h1 style="color: yellow;">노랑</h1>
	</c:if>
	<c:if test="${param.color == 3 }">
		<h1 style="color: blue;">파랑</h1>
	</c:if>

	<form action="07_colorSelect.jsp">
		<label for="color">색상을 선택하세요.</label><br> <select id="color"
			name="color">
			<option value="1">빨강</option>
			<option value="2">노랑</option>
			<option value="3">초록</option>
		</select>
		<p>
		<p>

			<label for="fruit">과일을 선택하세요.</label><br> <select id="fruit"
				name="fruit">
				<option value="1">사과</option>
				<option value="2">망고</option>
				<option value="3">수박</option>
			</select> 
			<hr>
			
			<input type="checkbox" name="item" value="신발"> 신발 <input
				type="checkbox" name="item" value="가방"> 가방 <input
				type="checkbox" name="item" value="벨트"> 벨트<br> <input
				type="checkbox" name="item" value="모자"> 모자 <input
				type="checkbox" name="item" value="시계"> 시계 <input
				type="checkbox" name="item" value="쥬얼리"> 쥬얼리<br>
			<br> <br>
			<br> <input type="submit" value="전송">
	</form>
</body>
</html>