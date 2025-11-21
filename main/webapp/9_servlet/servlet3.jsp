<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>한번의 매핑으로 여러요청을 처리하도록</h2>
	${resultValue }
	<ol>
		<li>URI:${uri }</li>
		<li>요청명:${commandStr }</li>
	</ol>
	<ul>
		<li><a href="./regist.m">회원가입</a></li>
		<li><a href="./login.m">로그인</a></li>
		<li><a href="./board.m">게시판</a></li>		
	</ul>
</body>
</html>