<%@page import="membership.memberDao"%>
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
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		String mySqlDriver = application.getInitParameter("MySqlDriver");
		String mySqlURL = application.getInitParameter("MySqlURL");
		String mySqlID = application.getInitParameter("MySqlId");
		String mySqlPw = application.getInitParameter("MySqlPw");
		
		MemberDao dao = new memberDao(mySqlDriver,mySqlURL,mySqlID,mySqlPw);
		MemberDao dto = dao.getMemberDto(userId,userPw);
		
		dao.close();
		
		if(dto.getId() !=null){
			session.setAttribute("userId",dto.getId());
			session.setAttribute("userPw",dto.getName());
			
			response.sendRedirect("loginForm.jsp");
		}else{
			request.setAttribute("LoginErrMsg", "로그인 오류입니다");
			request.getRequestDispatcher("loginform.jsp").forward(request,response);
		}
		
		
	%>
</body>
</html>