<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멀티 업로드</title>
</head>
<body>
	<h1>MultiFile Upload</h1>
	<div class="container">
		<form action="MultiUpload.do" method="POST" enctype="multipart/form-data">
			<div class="text-container">
				<span>파일 1 :</span> <input type="file" name="file01">
			</div>
			<div class="text-container">
				<span>파일 2 :</span> <input type="file" name="file02">
			</div>
			<div class="text-container">
				<span>파일 3 :</span> <input type="file" name="file03">
			</div>
			<div class="button-container">
				<input class="submit-button" type="submit" value="전송">
			</div>
		</form>
	</div>
</body>
</html>