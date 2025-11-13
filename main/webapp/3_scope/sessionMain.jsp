<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<String> lists = new ArrayList<>();
    	lists.add("list");
    	lists.add("collection");
    	
    	session.setAttribute("lists", lists);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>페이지 이동 후 session 영역 확인</h2>
	<a href="sessionLocation.jsp">페이지이동</a>
</body>
</html>