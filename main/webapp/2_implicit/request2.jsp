<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="requestParam.jsp" method="post">
		id : <input type="text" name="id" value=""><br>
		gender : <input type="radio" name="gender" value="man"> M
				 <input type="radio" name="gender" value="woman"> F
				 <br>
		hobby : <input type="checkbox" name="favo" value="game"> game
		        <input type="checkbox" name="favo" value="sports"> sports
				<input type="checkbox" name="favo" value="tour"> tour
				<br>
		introduction : <textarea name="intro" cols="30" rows="4"></textarea>
		<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>