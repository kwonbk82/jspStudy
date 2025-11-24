package fileupload;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadProcess")
@MultipartConfig(fileSizeThreshold = 1024*1024, maxFileSize = 10*1024*1024, maxRequestSize = 50*1024*1024)

public class uploadservlet extends HttpServlet{
	private final String UPLOAD_DIR = "c:/upload";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		try {
			Part filePart = req.getPart("attachedFile");
			String fileName = filePart.getSubmittedFileName();
			
			String ext = "";
			if(fileName !=null && fileName.contains("."));{
				ext=fileName.substring(fileName.lastIndexOf("."));
				
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		    	String newFileName = now+ext;
		    	
		    	File uploadDir = new File(UPLOAD_DIR);
		    	if(!uploadDir.exists()) {
		    		uploadDir.mkdirs();
		    	}
		    	if(fileName !=null && !fileName.isEmpty()) {
		    		File file = new File(uploadDir,newFileName);
		    		filePart.write(file.getAbsolutePath());
		    	}
		    	String name = req.getParameter("name");
		    	String title = req.getParameter("title");
		    	String[] cateArray  = req.getParameterValues("cate");
		    	StringBuffer cateBuf = new StringBuffer();
		    	
		    	if(cateArray ==null){
		    		cateBuf.append("선택없음");
		    	}else{
		    		for(String s : cateArray){
		    			cateBuf.append(s+".");
		    		}
		    	}
		    	
		    	MyfileDto dto = new MyfileDto();
		    	dto.setName(name);
		    	dto.setTitle(title);
		    	dto.setCate(cateBuf.toString());
		    	dto.setOfile(fileName);
		    	dto.setSfile(newFileName);
		    
		    	MyfileDao dao = new MyfileDao(getServletContext());
		    	dao.insertFile(dto);
		    	dao.close();
		    	
		    	resp.sendRedirect("fileList.jsp");
		    }
			}catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
				req.setAttribute("errorMessage","파일업로드 오류");
				req.getRequestDispatcher("fileUpliadMain.jsp").forward(req,resp);
			}
	}
	}
