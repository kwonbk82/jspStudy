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
	
	public MVCBoardDto selectView(String idx) {
		MVCBoardDto dto = new MVCBoardDto();
		String query = "SELECT * FROM mvcboard WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
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
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void updateVisitcount(String idx) {
		String query = "UPDATE mvcboard"+" SET visitcount = visitcount+1"+" WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시물 조회수 상승 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public void downcountPlus(String idx) {
		String query = "UPDATE mvcboard"+" SET downcount = downcount+1"+" WHERE idx = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("파일 다운로드 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public boolean confirmPassword(String pass,String idx) {
		boolean isPass = false;
		try {
			String query = "SELECT COUNT(*)"+" FROM mvcboard"+" WHERE pass=? AND idx=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, pass);
			psmt.setString(2, idx);
			rs = psmt.executeQuery();
			if(rs.getInt(1)==1) {
				isPass = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("비밀번호 확인 중 예외 발생");
			e.printStackTrace();
		}
		return isPass;
	}
	
	public int deletePost(String idx) {
		int result = 0;
		
		try {
			String query = "DELETE FROM mvcboard WHERE idx=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시글 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public int updatePost(MVCBoardDto dto) {
		int result = 0;
		try {
			String query = "UPDATE mvcboard" +" SET title=?, name=?, content=?, ofile=?, sfile=?"+" WHERE idx=? and pass=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getIdx());
			psmt.setString(7, dto.getPass());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("게시글 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
}

