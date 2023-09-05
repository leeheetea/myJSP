<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
<style>
body {
  background-color: #E6F7FF; /* 파랑색 계통 배경색 */
  display: flex;
  justify-content: start;
  align-items: center;
  flex-direction: column;
  height: 100vh; /* 화면 높이의 100% */
  margin: 0;
}

.container {
  background-color: white; /* 흰색 배경색 */
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.container span {
  display: inline-block;
  width: 70px;
}

.text-container {
  margin-top: 1rem;
}

.submit-button {
  margin-left: 16rem;
}

input[type="submit""], input[type="file"]{
	background-color: #E6F7FF;
	border-radius: 5px;
	color: white;
}

</style>
</head>
<body>
	<h1>File Upload</h1>
	<div class="container">
		<form action="upload.do" method="POST" enctype="multipart/form-data">
			<div class="text-container">
				<span>글쓴이 :</span> <input type="text" name="name">
			</div>
			<div class="text-container">
				<span>제목 :</span> <input type="text" name="title">
			</div>
			<div class="text-container">
				<span>파일 :</span> <input type="file" name="uploadFile">
			</div>
			<div class="text-container">
				<input class="submit-button" type="submit" value="전송">
			</div>
		</form>
	</div>
</body>
</html>
