package mvcboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MVCBoardDao dao = new MVCBoardDao();
		String idx = req.getParameter("idx");
		dao.updateVisitcount(idx);
		dao.selectView(idx);
		
		MVCBoardDto dto = dao.selectView(idx);
		dao.close();
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/11_mvcboard/view.jsp").forward(req, resp);
	}
}
