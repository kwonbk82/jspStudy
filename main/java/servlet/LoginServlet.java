package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void init() throws ServletException{
		System.out.println("로그인 서블릿 초기화");
	}
	public void destroy() {
		System.out.println("로그인 서블릿 소멸");
	}
	protected void sevice(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("로그인 서비스");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/6_session/loginForm.jsp").forward(req,resp);
	}
}
