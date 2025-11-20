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
	<h2>99단</h2>
	<p>1. 스크립틀릿과 표현식</p>
	<table border="1">
		<%
			for(int i=2;i<=9;i++){%>
				<tr>
					<%for (int j=1; j<=9;j++) {%>
					<td>
						<%=i %>*<%=j %>=<%=(i*j) %>
					</td>
					<%	}
		%>
				</tr>
		<%	}
		%>
	</table>
	<hr>
	
	<p>2. jstl,el</p>
		<table border="1">
			<c:forEach var="i" begin="2" end="9">
				<tr>
					<c:forEach>
						<td>${i }x${j }=${i*j }</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>