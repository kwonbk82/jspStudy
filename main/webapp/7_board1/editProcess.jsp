<%@page import="model1.BoardDao"%>
<%@page import="model1.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./isLoggedIn.jsp" %>
<%
	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDto dto = new BoardDto();
	dto.setNum(num);
	dto.setTitle(title);
	dto.setContent(content);
	
	BoardDao dao = new BoardDao(application);
	int result = dao.updateEdit(dto);
	
	dao.close();
	
	if(result ==1){
		response.sendRedirect("view.jsp?num"+dto.getNum());
	}else{
		JSFunction.alertBack("게시글 수정에 실패하셨습니다", out);
		return;
	}
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>