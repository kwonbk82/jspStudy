<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="responseHeader.jsp" method="get">
		날짜 형식 : <input type="text" name="add_date" value="2025-11-13 14:35"> <br>
		숫자 형식 : <input type="text" name="add_int" value="20251113143628"> <br>
		문자 형식 : <input type="text" name="add_str" value="2025년 11월 13일 14시 36분"> <br>
		<input type="submit" value="응답헤더 설정">
		
	</form>
</body>
</html>