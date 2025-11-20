<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" begin="3" end="5" varStatus="loop">
		<p>count : ${loop.count }</p>
		<p>index : ${loop.index }</p>
		<p>current : ${loop.current }</p>
		<p>first : ${loop.first }</p>
		<p>last : ${loop.last }</p>
		<hr>
	</c:forEach>
	<%
		String[] color = {"red","green","blue","black"};
	%>
	<c:forEach var="c" item="<%=color %>" >
		<p style="color:&{c};">${c }</p>
	</c:forEach>
	<hr>
</body>
</html>