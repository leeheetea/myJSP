<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #e6f3ff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* 화면 높이만큼 */
    }
    
    form {
        border: 1px solid #007BFF;
        padding: 20px;
        border-radius: 5px;
        background-color: #ffffff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        min-width: 300px;
    }
    
    input[type="text"], input[type="password"] {
        width: 90%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #007BFF;
        border-radius: 5px;
    }
    
    input[type="submit"], input[type="reset"], input[type="button"] {
        background-color: #007BFF;
        color: white;
        border: none;
        padding: 10px 20px;
        margin: 5px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    
    input[type="submit"]:hover, input[type="reset"]:hover, input[type="button"]:hover {
        background-color: #0056b3;
    }

</style>
<script type="text/javascript" src="Script/member.js" ></script>
</head>
<body>
  <form method="POST" action="login.do" name="frm">
  	<input type="text" name="userid" id="userid" placeholder="아이디" ><br>
  	<input type="password" name="pwd" id="pwd" placeholder="비밀번호" ><br>
  	<input type="submit" value="login" onclick="return loginCheck()"> &nbsp;&nbsp;
  	<input type="reset" value="reset"> &nbsp;&nbsp;
  	<input type="button" value="join" onclick="location.href='join.do'"> &nbsp;&nbsp;
  	<hr>
  	<p>${message }</p>
  </form>
</body>
</html>