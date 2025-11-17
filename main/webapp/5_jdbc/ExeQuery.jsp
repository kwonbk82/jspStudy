<%@page import="java.sql.*"%>
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
	<h2>회원 목록 조회 테스트</h2>
	<%
		JDBC_connect jdbc = new JDBC_connect();
		
		String sql = "SELECT id,pass,name,regidate FROM member";
		Statement stmt = jdbc.con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			String id = rs.getString(1);
			String pw = rs.getString(2);
			String name = rs.getString("name");
			Date regidate = rs.getDate("regidate");
			
			out.println(String.format("%s %s %s %s",id,pw,name,regidate)+"<br>");
		}
		jdbc.close();
	%>
</body>
</html>