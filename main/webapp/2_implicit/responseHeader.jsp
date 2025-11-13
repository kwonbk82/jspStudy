<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@	page import = "java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
		long add_date = s.parse(request.getParameter("add_date")).getTime();
		
		int add_int = Integer.valueOf(request.getParameter("add_int"));
		String add_str = request.getParameter("add_str");
		
		response.addDateHeader("today", add_date);
		response.addIntHeader("number", add_int);
		response.addHeader("study", add_str);
		
		response.addIntHeader("number", 3535);

	%>
	
	<h2>응답 헤더 정보 출력하기</h2>
	<%
		Collection<String> headerNames = response.getHeaderNames();
		for(String hn : headerNames){
			String hValue = response.getHeader(hn);
	%>
		<p><%= hn %> : <%=hValue %>
	<%
		}
	%>
</body>
</html>