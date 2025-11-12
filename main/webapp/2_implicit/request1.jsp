<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. 클라이언트와 서버의 환경정보 일기</h2>
	<a href="requestInfo.jsp?eng=Hello%kor=안녕">get 방식</a>
	<form action="requestInfo.jsp" method="post">
		한글 : <input type="text" name="kor" value="잘가세요"> <br>
		영어 : <input type="text" name="eng" value="Bye"> <br>
		<input type="submit" value="POST 방식">
	</form>
</body>
</html>