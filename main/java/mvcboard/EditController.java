package mvcboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import utils.JSFunction;

@WebServlet("/mvcboard/edit.do")
@MultipartConfig( fileSizeThreshold = 1024*1024,
maxFileSize = 1024*1024*50,
maxRequestSize = 1024*1024*100
)
public class EditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idx = req.getParameter("idx");
		MVCBoardDao dao = new MVCBoardDao();
		
		MVCBoardDto dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/11_mvcboard/edit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String saveDir= "c:upload";
		
		String idx = req.getParameter("idx");

		String prevOfile = req.getParameter("prevOfile");
		String prevSfile = req.getParameter("prevSfile");
		
		HttpSession session = req.getSession();
		String pass = (String) session.getAttribute("pass");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setIdx(req.getParameter("idx"));
		dto.setName(req.getParameter("name"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setPass(req.getParameter("pass"));
//		dto.setOfile(prevOfile);
//		dto.setOfile(prevSfile);
		
		Part part = req.getPart("ofile");
		String fileName = part.getSubmittedFileName();
		if(fileName != null && !fileName.isEmpty()) {
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date())+ext;
			part.write(saveDir + File.separator + newFileName);
			File old = new File(saveDir + File.separator+prevSfile);
			if(old.exists()) old.delete();
			
			dto.setOfile(fileName);
			dto.setSfile(newFileName);

		}else {
			dto.setOfile(prevOfile);
			dto.setSfile(prevSfile);
		}
		MVCBoardDao dao = new MVCBoardDao();
		int result = dao.updatePost(dto);
		dao.close();
		
		if(result ==1) {
			session.removeAttribute("pass");
			resp.sendRedirect("../mvcboard/view/do?idx="+idx);
		}else {
			JSFunction.alertLocation(resp, "비밀번호를 확인하세요", "../mvcboard/view/do?idx="+idx);
		}
		
	}
}
