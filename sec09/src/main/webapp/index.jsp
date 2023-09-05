<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #e6f3ff;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh; /* 화면 높이만큼 */
    }
    
    h1{
    
    }
    
    a{
    text-decoration-line: none;
    font-size: large;
    color: black;
    }
    
    button {
        background-color: #007BFF;
        color: white;
        border: none;
        padding: 10px 20px;
        margin: 5px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
</style>
</head>
<body>
  <h1>어서오세요 환영합니다.</h1>
  <div>
  	<a href="login.do"><button>로그인</button></a>
  </div>
</body>
</html>