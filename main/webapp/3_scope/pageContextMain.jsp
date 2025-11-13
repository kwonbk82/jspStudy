<%@page import="common.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("pageInteger", 1000);
	pageContext.setAttribute("pageString", "letter in page");
	pageContext.setAttribute("pagePerson", new PersonDTO("김블루",23));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>page 영역의 값읽어오기</h2>
	<%
	// getAttribute는 object타입으로 가져온다
		Object pInteger = (Integer)(pageContext.getAttribute("pageInteger"));
		Object pString = pageContext.getAttribute("pageString");
		Object pPerson = (PersonDTO)(pageContext.getAttribute("pagePerson"));
	%>
	
	<ul>
		<li>Integer 객체 : <%=pInteger %></li>
		<li>String 객체 : <%=pString %></li>
		<li>Person 객체 : <%=((PersonDTO)pPerson).getName() %>, <%= ((PersonDTO)pPerson).getAge() %></li>
	</ul>
	<h2> include로 page영역 읽어오기</h2>
	<%@ include file ="pageInclude.jsp" %>
</body>
</html>