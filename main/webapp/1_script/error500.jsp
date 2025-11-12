<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		int age = Integer.valueOf(request.getParameter("age"))+10;
		out.println("너는 10년 후에"+age+"살이된다");
	%>
</body>
</html>