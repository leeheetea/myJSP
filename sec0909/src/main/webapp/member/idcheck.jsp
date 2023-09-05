<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="Script/member.js"></script>
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

    span, input[type="text"] {
        margin-bottom: 10px;
    }

    input[type="text"], input[type="password"] {
        padding: 10px;
        border: 1px solid #007BFF;
        border-radius: 5px;
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
  <h2>아이디 중복 확인</h2>
  <form action="idCheck.do" method="get" name="frm">
    <div>
    	<span>아이디</span>
    	<input type="text" name="userid" value="${userid }">
    	<input type="submit" value="중복확인">

    </div>
    
    <c:if test="${result == -1 }">
    ${userid }는 사용 가능한 아이디입니다.
    <input type="button" value="사용" onclick="idok()">
    </c:if>
    
    <c:if test="${result == 1 }">
    <script type="text/javascript">
   	  opener.document.frm.userid.value="";
    </script>
        ${userid }는 이미 사용중인 아이디입니다.
    </c:if>
  </form>
</body>
</html>