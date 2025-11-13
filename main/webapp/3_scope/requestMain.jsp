<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  // 	request.setAttribute(arg0, arg1);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.removeAttribute("requestString");
		request.removeAttribute("requestInteger");
	%>
	<h2> request영역의 속성값 일겅오기</h2>
	<%
	//Person rPerson = (Person)request.getAttribute("requestPerson");
	%>
</body>
</html>