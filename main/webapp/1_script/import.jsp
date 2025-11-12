<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	page import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강일용</title>
</head>
<body>
	<h2>제목</h2>
	<%
		Date today = new Date();
		out.println("오늘 날짜 : " +today);
	%>
</body>
</html>