package mvcboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.JDBC_connect;

public class MVCBoardDao extends JDBC_connect{
	public MVCBoardDao() {
		super();
	}
	
//	검색
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		String query = "SELECT COUNT(*) FROM mvcboard";
		
		if(map.get("searchWord") != null) {
			query += " WHERE "+map.get("searchField")+" LIKE '%"+map.get("searchWord")+"%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 개수 세는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<MVCBoardDto> selectList(Map<String, Object> map) {
		List<MVCBoardDto> board = new ArrayList<MVCBoardDto>();
		
		String query = "SELECT * FROM mvcboard";
		
		if(map.get("searchWord") != null) {
			query += " WHERE "+map.get("searchField")+" LIKE '%"+map.get("searchWord")+"%'";
		}
		query += " ORDER BY idx DESC";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
				
				board.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 목록 조회 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}
	
	public int insertWrite(MVCBoardDto dto) {
		int result = 0;
		
		try {
			String query = "INSERT INTO mvcboard (name,title,content,ofile,sfile,pass)"+" VALUES(?,?,?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getPass());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 등록 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
}

