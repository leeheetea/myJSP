<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #e6f3ff;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        height: 100vh; 
        margin: 0;
    }

    form {
        border: 1px solid #007BFF;
        padding: 20px;
        border-radius: 5px;
        background-color: #ffffff;
        text-align: center; /* 내용 중앙 정렬 */
    }

    p {
        color: #007BFF;
        margin-bottom: 20px;
    }

    input[type="submit"], input[type="button"] {
        background-color: #007BFF;
        color: white;
        border: none;
        padding: 10px 20px;
        margin: 5px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover, input[type="button"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
	<h2>회원 전용 페이지</h2>
	<form action="logout.do">
		<p>안녕하세요. ${loginUser.name}(${loginUser.userid })님</p>
		<div>
			<input type="submit" value="logout" onclick="location.href='logout.do'"> &nbsp;
			<input type="button"  value ="infoFix" onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">
		</div>
	</form>
</body>
</html>