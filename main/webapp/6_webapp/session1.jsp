<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	
    	long creationTime = session.getCreationTime();
    	String creationTimeStr = dateFormat.format(new Date(creationTime));
    	
    	long lastTime = session.getLastAccessedTime();
    	String lastTimeStr = dateFormat.format(new Date(lastTime));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 설정 확인</h2>
	<p>세션 유지 시간 : <%= session.getMaxInactiveInterval() %></p>
	<p>세션 아이디 : <%= session.getId() %></p>
	<p>최초 요청 시간 : <%= creationTimeStr %></p>
	<p>마지막 요청 시간 : <%= lastTimeStr %></p>
</body>
</html>