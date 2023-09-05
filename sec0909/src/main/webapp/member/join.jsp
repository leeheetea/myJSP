<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #e6f3ff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* 화면 높이만큼 */
    }

label {
    display: inline-block;
    width: 7rem;
}

.container {
    border: 1px solid #007BFF; /* 파랑색 계열의 테두리 */
    margin: 0 auto; 
    width: 90%; 
    padding: 2rem; 
    background-color: #e6f3ff; /* 파랑색 계열의 배경색 */
}

.id-container {
    display: flex;
}

.id-container > input[type="text"] {
	margin-left : 4.5px;
}

 input[type="button"]{
  background-color: #007BFF;
  color: white;
  border-radius: 5px;
 }

/* 추가 스타일 */
input[type="submit"], input[type="reset"] {
    background-color: #007BFF; 
    color: white; 
    border: none;
    padding: 10px 20px;
    margin: 10px 5px;
    border-radius: 5px; 
    cursor: pointer;
}

input[type="submit"]:hover, input[type="reset"]:hover {
    background-color: #0056b3; /* 버튼 호버 색상 */
}

input[type="text"], input[type="email"], input[type="password"], input[type="tel"] {
    padding: 5px 10px;
    border-radius: 5px;
    border: 1px solid #007BFF;
   
}
.submit-button-container{
	display: flex;
	justify-content: center;
	margin: 0 auto;
}
</style>
<script type="text/javascript" src="Script/member.js" ></script>
</head>
<body>
	<form method="POST" name="frm" id="reg_frm" action="join.do">
		<div class="container">
		<label for="name">이름</label>
		<input type="text" name="name" id="name" required><br> 
		
		<div class="id-container">
			<label for="userid"> 아이디 </label>
			<input type="text" name="userid" id="userid" size="20" required><br> 
			<input type="hidden" name="reid" size="20">
		<div>
			<input type="button" value="중복 확인" onclick="idCheck()">
		</div>
		</div>
		
		<label for="email"> 이메일 </label>
		<input type="email" id="email" name="email"required><br> 
		
		<label for="pwd"> 비밀번호 </label>
		<input type="password" id="pwd" name="pwd"  required><br> 
		
		<label for="pwd_check""> 비밀번호 확인 </label>
		<input type="password" id="pwd_check" name="pwd_check"  required><br>
		
		<label for="phone"> 전화번호 </label>
		<input type="tel" id="phone" name="phone"required><br>
		
		<label for="admin"> 회원등급</label>
		<input type="radio" name="admin" value="0" checked>일반회원 
		<input type="radio" name="admin" value="1">관리자 
		</div>
		<div class="submit-button-container">
			<input type="submit" value="회원등록" onclick="return joinCheck()">
			<input type="reset" value="취소" onclick="history.back()">
		</div>
	</form>
	
	<p>${message }</p>

</body>
</html>