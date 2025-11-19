<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../7_board1/link.jsp"></jsp:include>
	<h2>login page</h2>
	
	
	<p style="color : red; font-size : 1.2em;">
	<%=
		request.getAttribute("LoginErrMsg") == null ? " " :request.getAttribute("LoginErrMsg")
	%>
	</p><br>
	<%
		if(session.getAttribute("userId")==null){
			
			%>
			<script>
				function validateForm(form){
					if (!form.user_id.value) {
						alert("아이디를 입력하세요");
						return false;
					} if (!form.user_pw.value) {
						alert("비밀번호를 입력하세요");
						return false;
					}
				}
			</script>
			<form action="loginProcess.jsp" method="post" name="loginForm" onsubmit="return validateForm(this);">
		id : <input type="text" name="user_id"><br>
		pw : <input type="password" name="user_pw"><br>
		 <input type="submit" value="로그인"><br>
	
	</form>
			<%
		}else{
			
			%>
			<p><%= session.getAttribute("userName") %>>님, 로그인 하셨습니다.</p>
			<a href="logout.jsp">[로그아웃]</a>
			
			<%
		}
	%>
	
</body>
</html>