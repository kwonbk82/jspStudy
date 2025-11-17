<%@page import="common.JDBC_connect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JDBC 테스트 1</h2>
	<%
		JDBC_connect jdbc1= new JDBC_connect();
		jdbc1.close();
	%>
	
	<h2>JDBC 테스트 2</h2>
	<%
		String driver = application.getInitParameter("MySqlDriver");
		String url = application.getInitParameter("MySqlURL");
		String id = application.getInitParameter("MySqlId");
		String pw = application.getInitParameter("MySqlPw");
		
		JDBC_connect jdbc2 = new JDBC_connect(driver,url,id,pw);
		jdbc2.close();
	%>
	<h2>JDBC 테스트 3</h2>
	<%
		
		JDBC_connect jdbc3 = new JDBC_connect(application);
		jdbc3.close();
	%>

</body>
</html>
	