<%@page import="fileupload.MyfileDto"%>
<%@page import="java.util.List"%>
<%@page import="fileupload.MyfileDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>DB에 등록된 파일 목록 보기</h2>
	<a href="fileUploadMain.jsp">파일 등록하기</a>
	<%
		MyfileDao dao = new MyfileDao(application);
		List<MyfileDto> fileLists = dao.myFileList();
		dao.close();
	%>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>카테고리</th>
			<th>원본 파일명</th>
			<th>저장된 파일명</th> 
			<th>작성일</th>
			
		</tr>
	</table>
</body>
</html>