package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.m")
public class FrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		
		int lastSlash = uri.lastIndexOf("/");
		String commandStr = uri.substring(lastSlash);
		if(commandStr.equals("/regist.m")) registFunc(req);
		else if(commandStr.equals("/login.m")) loginFunc(req);
		else if(commandStr.equals("/board.m")) boardFunc(req);
		
		req.setAttribute("uri", uri);
		req.setAttribute("commandStr", commandStr);
		
		req.getRequestDispatcher("/9_serlvet/servlet4.jsp").forward(req, resp);
	}
	
	void registFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>회원가입</h4>");
	}
	void loginFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>로그인</h4>");
	}
	void boardFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>게시판</h4>");
	}
}
