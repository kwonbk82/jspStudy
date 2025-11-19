<%@page import="model1.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model1.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	BoardDao dao = new BoardDao(application);
    	
    	Map<String,Object> param = new HashMap<>();
    	String searchField = request.getParameter("searchField");
    	String searchWord = request.getParameter("searchWord");
    	
    	if(searchWord != null){
    		param.put("searchField",searchField);
    		param.put("searchWord",searchWord);
    	}
    	
    	int totalCount = dao.selectCount(param);
    	List<BoardDto> boardLists = dao.selectList(param);
    	dao.close();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./link.jsp" />
	
	<h2>게시글 목록보기</h2>
	
	<!-- 검색창 -->
	<form method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center">
					<select name="searchField">
						<option value="title"> 제목 </option>
						<option value="content"> 내용 </option>
					</select>
					<input type="text" name="searchWord">
					<input type="submit" name="검색하기">
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 게시글 목록 표시 -->
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		
		<%
			if(boardLists.isempty()){
				%>
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>

		</tr>
				<%
			}else{
				int virtualNum = 0;
				for(BoardDto dto : boardLists){
					virtualNum = totalCount--;
				%>
			<tr>
				<td><%= dto.getNum() %></td>
				<td>
					<a href="view.jsp?num=<%= dto.getNum()%>"><%= dto.getTitle() %></a>
				</td>
				<td><%= dto.getId() %></td>
				<td><%= dto.getVisitcount() %></td>
				<td><%= dto.getPostdate() %></td>
			</tr>
			<%
			}
			}
		%>
		
		
	</table>
	
	<!-- 글쓰기 -->
	<table border="1" width="90%">
		<tr align="right"> 
			<td>
				<button type="button" onchange="../7_board1/write.jsp">글쓰기</button>
			</td>
		</tr> 
	</table>
</body>
</html>




