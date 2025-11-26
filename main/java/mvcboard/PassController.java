package mvcboard;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.JSFunction;

@WebServlet("/mvcboard/pass.do")
public class PassController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/11_mvcboard/pass.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		
		MVCBoardDao dao = new MVCBoardDao();
		boolean confirmed = dao.confirmPassword(pass, idx);
		dao.close();
		
		if(confirmed) {
			if("edit".equals(mode)) {
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				resp.sendRedirect("../mvcboard/edit.do?idx="+idx);
			}else if("delete".equals(mode)) {
				dao = new MVCBoardDao();
				MVCBoardDto dto = dao.selectView(idx);
				int result = dao.deletePost(idx);
				dao.close();
				
				if(result ==1) {
					String saveDir = "c:/upload";
					File file = new File(saveDir,dto.getSfile());
					if(file.exists()) file.delete();
					
				}
				JSFunction.alertLocation(resp, "삭제되었습니다", "../mvcboard/list.do");

			}
		}else {
			JSFunction.alertBack(resp, "비밀번호가 일치하지 않습니다");

		}
	}
}
