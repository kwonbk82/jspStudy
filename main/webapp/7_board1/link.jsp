<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="1" width="90%">
	<tr>
		<td align="center">
			<%
				if(session.getAttribute("userId")==null){
					 %>
					 <a href="../6_session/loginForm.jsp">[로그인]</a>
					 <%
				}else{
					%>
					<a href="../6_session/logout.jsp">[로그아웃]</a>
				<%	
				}
			%>
			
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="../7_board1/list.jsp"></a>
		</td>
	</tr>
</table>