<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
label{
display: inline-block;
width: 7rem
}
.container{
border: 1px solid black;
}
</style>
</head>
<body>
	<form method="POST" name="frm" id="reg_frm" action="02_addMember.jsp">
		<div class="container">
		<label for="name">이름</label>
		<input type="text" name="name" id="name" required><br> 
		
		<label for="userId"> 아이디 </label>
		<input type="text" name="userId" id="userId" required><br> 
		
		<label for="email"> 이메일 </label>
		<input type="email" id="email" name="email"required><br> 
		
		<label for="pwd"> 비밀번호 </label>
		<input type="password" id="pwd" name="pwd"  required><br> 
		
		<label for="pwd_re"> 비밀번호 확인 </label>
		<input type="password" id="pwd_re" name="pwd_re"  required><br>
		
		<label for="phone"> 전화번호 </label>
		<input type="tel" id="phone" name="phone"required><br>
		
		<label for="admin"> 회원등급</label>
		<input type="radio" name="admin" value="1">관리자 
		<input type="radio" name="admin" value="0">일반회원 
		</div>
		<div id="button">
			<input type="submit" value="회원가입">
			<input type="reset" value="취소">
		</div>
	</form>
	<script></script>
</body>
</html>