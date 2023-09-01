<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="com.keduit.MemberBean" />
<jsp:setProperty property="*" name="member" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elMember</title>
</head>
<body>
<h1> EL </h1>
이름 : ${member.name}<br>
아이디 : ${member.userId}<br>
비밀번호 : ${member.pwd}<br>
닉네임 : ${member.nickName}<br>
</body>
</html>