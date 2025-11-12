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
		String id = request.getParameter("id");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("favo");
		String hobbyStr = "";
		if(hobby !=null){
			for(int i=0;i<hobby.length;i++){
				hobbyStr += hobby[i]+", ";
			}
		}
		
		String intro = request.getParameter("intro").replace("\r\n","<br>");
	%>
	<ul>
		<li> 아이디 : <%=id %></li>
		<li> 성별 : <%=gender %></li>
		<li> 취미 : <%=hobbyStr %></li>
		<li> 자기소개 : <%=intro %></li>
	</ul>
</body>
</html>