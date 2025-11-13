<%@page import="common.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	인클루딩
	
	<%
	// getAttribute는 object타입으로 가져온다
		int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
		String pString2 = pageContext.getAttribute("pageString").toString();
		PersonDTO pPerson2 = (PersonDTO)(pageContext.getAttribute("pagePerson"));
	%>
	
	<ul>
		<li>Integer 객체 : <%=pInteger2 %></li>
		<li>String 객체 : <%=pString2 %></li>
		<li>Person 객체 : <%=pPerson2.getName() %>, <%= pPerson2.getAge() %></li>
	</ul>
</body>
</html>