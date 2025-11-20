package model1;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.JDBC_connect;
import jakarta.servlet.ServletContext;

public class BoardDao extends JDBC_connect{
	public BoardDao(ServletContext application) {
		super(application);
	}
	
	public int selectCount(Map<String,Object> map) {
		int totalCount = 0;
		String query = "SELECT COUNT(*) FROM board";
		
		if(map.get("searchWord") != null) {
			query += " WHERE" +map.get("searchField")+" LIKE '%'"+map.get("searchWord")+"'%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 찾는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<BoardDto> selectList(Map<String,Object> map){
		List<BoardDto> bbs = new ArrayList<BoardDto>();
		
		String query = "SELECT * FROM board";
		if(map.get("searchWord") != null) {
			query += " WHERE" +map.get("searchField")+" LIKE '%'"+map.get("searchWord")+"'%'";
		}
		query +="ORDER BY num DESC";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
	
	public int insertWrite(BoardDto dto) {
		int result =0;
		try {
			String query = "INSERT INTO board(title,content,id,visitcount"+"VALUES(?,?,?,0)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 등록 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public BoardDto selectView(String num) {
		BoardDto dto = new BoardDto();
		
		String query = "SELECT B.*, M.name"+" FROM member M INNER JOIN board B"+" ON M.id=B.id"+" WHERE num=?";
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setId(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	public void updateVisitCount(String num) {
		String query = "UPDATE board"+"SET visitcount = visitcount +1"+"WHERE num=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public int updateEdit(BoardDto dto) {
		int result =0;
		try {
			String query = "UPDATE board"+"SET title=?,content=?"+"WHERE num =?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	public int deletePost(BoardDto dto) {
		int result = 0;
		try {
			String query = "DELETE FROM board WHERE num=?";
			
			psmt=con.prepareStatement(query);
			psmt.setString(1, dto.getNum());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();		
			}
		return result;
	}
	
}
