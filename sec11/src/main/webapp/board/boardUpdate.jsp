<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 수정 </title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
  <h1>게시글 수정</h1>
  <form method="POST" action="BoardServlet" name="frm">
    <input type="hidden" name="command" value="board_update">
    <input type="hidden" name="num" value="${board.num }">
    <table>
      <tr>
        <th>작성자</th>
        <td><input type="text" name="name" placeholder="필수항목" value="${board.name }" required></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name="pass" autocomplete="current-password" placeholder="필수항목" required></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type="email" name="email" value="${board.email }"></td>
	  </tr>
	  <tr>
	    <th>제목</th>
	    <td><input type="text" name="title" placeholder="필수항목" value="${board.title }" required></td>
	  </tr>
	  <tr>
	    <th>내용</th>
	    <td><textarea name="content" rows="15" cols="70" >${board.name } </textarea></td>
	  </tr>
    </table>
    <br><br>
    <input type="submit" value="수정" onclick="return boardCheck()">
    <input type="reset" value="다시작성">
    <input type="button" value="목록" onclick="location.href=BoardServlet?command=board_list">
  </form>
</body>
</html>