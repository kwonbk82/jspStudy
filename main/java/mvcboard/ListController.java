package mvcboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MVCBoardDao dao = new MVCBoardDao();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		
		if(searchWord != null) {
			map.put("searchField",searchField);
			map.put("searchWord",searchWord);
		}
		int totalCount = dao.selectCount(map);
		
		List<MVCBoardDto> boardLists = dao.selectList(map);
		dao.close();
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/11_mvcboard/list.jsp").forward(req, resp);
	}
}
