<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키설정</h2>
	<%
		//쿠키(키,값)
		Cookie cookie = new Cookie("myCookie","내가만든쿠키");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
	%>

	<h2>쿠키 설정 후 쿠키값 확인하기</h2>	
	<%
		Cookie[] cookies =request.getCookies();
		if(cookies !=null){
			for(Cookie c : cookies){
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				
				out.println(String.format("%s : %s <br>", cookieName, cookieValue));
			}
		}
	%>
	
	<h2>페이지 이동 후 쿠키값 확인하기</h2>
	<a href="cookieResult.jsp">쿠키값 확인</a>
	
</body>
</html>