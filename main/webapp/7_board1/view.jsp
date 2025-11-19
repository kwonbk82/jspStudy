<%@page import="model1.BoardDto"%>
<%@page import="model1.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String num = request.getParameter("num");
    BoardDao dao = new BoardDao(application);
    dao.updateVisitCount(num);
    BoardDto dto = dao.selectView(num);
    dao.close();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>

</head>
<body>
<%@ include file="../7_board1/link.jsp" %>

<h2>회원제 게시판 - 상세 보기(View)</h2>
<form name="writeFrm">
    <table border="1" width="90%">
        <tr>
            <td>번호</td>
            <td><%= dto.getNum() %></td>
            <td>작성자</td>
            <td><%= dto.getName() %></td>
        </tr>
        <tr>
            <td>작성일</td>
            <td><%= dto.getPostdate() %></td>
            <td>조회수</td>
            <td><%= dto.getVisitcount() %></td>
        </tr>
        <tr>
            <td>제목</td>
            <td colspan="3"><%= dto.getTitle() %></td>
        </tr>
        <tr>
            <td>내용</td>
            <td colspan="3" height="100"><%= dto.getContent().replace("\r\n","<br>") %></td> 
        </tr>
        <tr>
            <td colspan="4" align="center">
            <% if(session.getAttribute("userId") !=null && session.getAttribute("userId").equals(dto.getId())){
            	
            
            %>
                <button type="button">수정하기</button>
                <button type="button">삭제하기</button> 
                
              <%} %>
                <button type="button" onclick="location.href='list.jsp';">
                    목록 보기
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>