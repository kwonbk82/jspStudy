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
<table>
	<%
	
		JDBC_connect jdbc = new JDBC_connect();
		String sql = "select * from student";
		Statement stmt = jdbc.con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			String num = rs.getString(1);
			String name = rs.getString("name");
			String depart = rs.getString("depart");
			String address = rs.getString("address");
			String phone = rs.getString("phone");
		
		%>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>학과</th>
			<th>주소</th>
			<th>연락처</th>
		</tr>
		<tr>
			<td><%=num %></td>
			<td><%=name %></td>
			<td><%=depart %></td>
			<td><%=address %></td>
			<td><%=phone %></td>
		</tr>
		
	
	<%
		}
		jdbc.close();
	%>
	</table>
	
</body>
</html>