<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> IP : <%= request.getRemoteAddr() %>
	<p> 요청 정보 길이 : <%= request.getContentLength() %>
	<P> 요청 정보 인코딩 : <%= request.getCharacterEncoding() %>
	<p> 요청 정보 컨텐츠 유형 : <%= request.getContentType() %>
	<p> 요청 정보 프로토콜 : <%= request.getMethod() %>
	<p> 요청 URL : <%= request.getRequestURL() %>
	<p> 요청 URI : <%= request.getRequestURI() %>
	<p> 컨텍스트 경로 : <%= request.getContextPath() %>
	<p> 서버 이름 : <%= request.getServerName() %>
	<p> 서버 포트 : <%= request.getServerPort() %>
	<p> 쿼리스트링 : <%= request.getQueryString() %>
	<p> 전송된 값 1 : <%= request.getParameter("eng") %>
	<p> 전송된 값 2 : <%= request.getParameter("kor") %>
	
	
</body>
</html>