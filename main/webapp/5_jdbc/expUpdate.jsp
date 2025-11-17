<%@page import="java.sql.PreparedStatement"%>
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
	<h2>회원 추가 테스트</h2>
	<%
		JDBC_connect jdbc = new JDBC_connect();
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	String sql = "INSERT INTO member VALUES(?,?,?,current_date)";
		
			PreparedStatement psmt = jdbc.con.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pw);
	psmt.setString(3, name);
	
	int inResult = psmt.executeUpdate();
	out.println(inResult+"행이 추가되었습니다");
	
	jdbc.close();
	
	%>
</body>
</html>