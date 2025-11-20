<%@page import="model1.BoardDao"%>
<%@page import="model1.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%@ include file="./isLoggedIn.jsp" %>
<%
	String num = request.getParameter("num");
	BoardDto dto = new BoardDto();
	BoardDao dao = new BoardDao(application);
	dto = dao.selectView(num);
	
	String sessionId = session.getAttribute("userId").toString();
	int delResult = 0;
	if(sessionId.equals(dto.getId())){
		dto.setNum(num);
		
		delResult = dao.deletePost(dto);
		dao.close();
		if(delResult ==1){
			JSFunction.alertLocation("삭제되었습니다.", "list.jsp", out);
		}else{
			JSFunction.alertBack("삭제에 실패하셨습니다", out);

		}
		
	}else{
		JSFunction.alertBack("삭제는 본인만 가능", out);
		return;
	}
%>