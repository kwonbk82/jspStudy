<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>web.xml에 설정한 내용 읽어오기</h2>
	
	초기화 매개변수 : <%= application.getInitParameter("INIT_PARAM1") %>
	
	<h2>서버 물리적 경로 얻기</h2>
	
	application 내장객체 : <%= application.getRealPath("2_implicitObject") %>
	
	<h2>선언부에서 application 내장객체 사용하기</h2>
	
	<%!
		public String useImplObject(){
		return this.getServletContext().getRealPath("/2_implicitObject");
	}
	
		public String useImplObject(ServletContext app){
		return app.getRealPath("/2_implicitObject");
	}
	%>
	
	<ul>
		<li>this 사용 : <%=useImplObject() %></li>
		<li>내장객체 전달 : <%=useImplObject(application) %></li>
	</ul>
	
	
</body>
</html>