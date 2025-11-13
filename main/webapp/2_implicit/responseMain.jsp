<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String loginErr = request.getParameter("loginErr");
		if(loginErr != null) out.print("login failed");
	%>
	<br>
	<form action="" method="post" >
		id : <input type="text" name="user_id"> <br>
		pw : <input type="text" name="user_pw"> <br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>