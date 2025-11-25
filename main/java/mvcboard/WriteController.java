package mvcboard;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import utils.JSFunction;

@MultipartConfig( fileSizeThreshold = 1024*1024,
				maxFileSize = 1024*1024*50,
				maxRequestSize = 1024*1024*100
			)

public class WriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/11_mvcboard/write.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String saveDirectory = "c:upload";
		File uploadDir = new File(saveDirectory);
		if(!uploadDir.exists()) uploadDir.mkdirs();
		
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		Part part = null;
		
		try {
			part = req.getPart("ofile");
			
			if(part != null && part.getSize() > maxPostSize) {
				JSFunction.alertLocation(resp, "첨부파일이 용량을 초과합니다", "../mvcboard/write.do");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JSFunction.alertLocation(resp, "파일 업로드 중 오류가 발생했습니다", "../mvcboard/write.do");
			return;
		}
		String originalFileName = null;
		String savedFileName = null;
		
		if (part !=null && part.getSize()>0) {
			originalFileName = getFileName(part);
			if(originalFileName != null && !originalFileName.isEmpty()) {
				String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
				String newFileName = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date())+ext;
				savedFileName = newFileName;
				
				File saveFile = new File(saveDirectory,savedFileName);
				part.write(saveFile.getAbsolutePath());
			}
		}
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setName(req.getParameter("name"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setPass(req.getParameter("pass"));
		dto.setOfile(originalFileName);
		dto.setOfile(savedFileName);
		
		MVCBoardDao dao = new MVCBoardDao();
		int result = dao.insertWrite(dto);
		dao.close();
		
		if(result ==1) resp.sendRedirect("../mvcboard/list.do");
		else resp.sendRedirect("../mvcboard/write.do");
	}
	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		if(header ==null) return null;
		for(String name : header.split(";")) {
			if(name.trim().startsWith("fileName")) {
				return name.substring(name.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}
}



