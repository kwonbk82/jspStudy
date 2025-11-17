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
<%
	JDBC_connect jdbc = new JDBC_connect();

	String num = request.getParameter("num");
	String name = request.getParameter("name");
	String depart = request.getParameter("depart");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	
	String sql = "INSERT INTO student values(?,?,?,?,?)";
	
	PreparedStatement psmt = jdbc.con.prepareStatement(sql);
	psmt.setString(1,num);
	psmt.setString(2,name);
	psmt.setString(3,depart);
	psmt.setString(4,address);
	psmt.setString(5,phone);
	
	psmt.executeUpdate();
	jdbc.close();
	

%>

		
</body>
</html>