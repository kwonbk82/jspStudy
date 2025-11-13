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
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		if(id.equals("admin")&&pw.equals("1234")){
			response.sendRedirect("responseWelcome.jsp");
		}else{
			request.getRequestDispatcher("responseMain.jsp?loginErr=1").forward(request, response);
			
		}
	%>
</body>
</html>