<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="number" value="100"/>
	<c:set var="string" value="JSP"/>
	
	<c:if test="${number % 2==0}" var="result">
		${number }은 짝수
	</c:if>
	<c:if test="${not result}" var="result">
		${number }은 홀수
	</c:if>
	<c:if test="${string eq 'JAVA'}" var="result2">
		문자열은 JAVA입니다
	</c:if>
	<c:if test="${not result}" >
		문자열은 JAVA 아임다
	</c:if>
	
	
</body>
</html>