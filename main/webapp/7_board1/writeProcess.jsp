<%@page import="model1.BoardDao"%>
<%@page import="model1.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- confirm login -->
<%@ 
	include file="./isLoggedIn.jsp"
%>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	BoardDto dto =new BoardDto();
	dto.setTitle(title);
	dto.setContent(content);
	
	dto.setId(session.getAttribute("userId").toString());
	
	BoardDao dao = new BoardDao(application);
	int iResult = dao.insertWrite(dto);
	dao.close();
	
	if(iResult ==1){
		response.sendRedirect("list.jsp");
	}else{
		JSFunction.alertBack("글쓰기에 실패하셨습니다", out);
	}
	
%>