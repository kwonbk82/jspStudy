package mvcboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

@WebServlet("/mvcboard/download.do")
public class DownloadController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		String idx = req.getParameter("idx");
		
		String saveDir = "c:/upload";
		File file = new File(saveDir,sfile);
		
		if(!file.exists()) {
			JSFunction.alertBack(resp, "파일이 존재하지 않습니다");
			return;
		}
		
		ofile = new String(ofile.getBytes("UTF-8"),"ISO-8859-1");
		
		resp.reset();
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition","attachment; filename=\""+ofile+"\"");
		resp.setHeader("Content-Length", String.valueOf(file.length()));
		
		try (InputStream in = new FileInputStream(file);
				OutputStream out = resp.getOutputStream()){
			byte[] buffer = new byte[4096];
			int bytesRead;
			while((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		MVCBoardDao dao = new MVCBoardDao();
		dao.downcountPlus(idx);
		dao.close();
		
	}
}
