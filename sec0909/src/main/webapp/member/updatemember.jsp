<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style type="text/css">

h1 {
display: block;
margin: 0 auto;
text-align: center;
margin-bottom: 3rem;
}

label {
    display: inline-block;
    width: 7rem;
}

.container {
    border: 1px solid #007BFF; /* 파랑색 계열의 테두리 */
    margin: 0 auto; 
    width: 30%; 
    padding: 2rem; 
    background-color: #e6f3ff; /* 파랑색 계열의 배경색 */
}

.id-container {
    display: flex;
}

.id-container > input[type="text"] {
	margin-left : 4.5px;
}

/* 추가 스타일 */
input[type="submit"], input[type="reset"] {
    background-color: #007BFF; /* 파랑색 계열 */
    color: white; /* 버튼의 글자색을 흰색으로 */
    border: none;
    padding: 10px 20px;
    margin: 10px 5px;
    border-radius: 5px; /* 둥근 모서리 */
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
<h1>회원정보 수정</h1>
	<form method="POST" name="frm" id="reg_frm" action="memberUpdate.do" onsubmit="return joinCheck();">
		<div class="container">
		<label for="name">이름</label>
		<input type="text" name="name" id="name" value="${name }" required><br> 
		
		<div class="id-container">
			<label for="userid"> 아이디 </label>
			<input type="text" name="userid" value="${userid }" id="userid" size="20" readonly required><br> 
		</div>
		
		<label for="email"> 이메일 </label>
		<input type="email" id="email" value="${email }" name="email"required><br> 
		
		<label for="pwd"> 비밀번호 </label>
		<input type="password" id="pwd" value="${pwd }" name="pwd"  required><br> 
		
		<label for="pwd_check""> 비밀번호 확인 </label>
		<input type="password" id="pwd_check" value="${pwd }" name="pwd_check"  required><br>
		
		<label for="phone"> 전화번호 </label>
		<input type="tel" id="phone" value="${phone }" name="phone"required><br>
		
		<label for="admin"> 회원등급</label>
		<input type="radio" name="admin" value="0" ${admin == 0 ? "checked" : ""}>일반회원 
		<input type="radio" name="admin" value="1" ${admin == 1 ? "checked" : ""}>관리자 
		</div>
		<div class="submit-button-container">
			<input type="submit" value="수정완료">
			<input type="reset" value="취소" onclick="history.back()">
		</div>
	</form>
	
	<p>${message }</p>

</body>
</html>