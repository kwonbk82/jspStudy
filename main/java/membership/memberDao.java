package membership;

import common.JDBC_connect;

public class memberDao extends JDBC_connect{

	public memberDao(String driver,String url,String id,String pw ) {
		super(driver,url,id,pw);
	}
	public MemberDto getMemberDto(String uid,String upw) {
		MemberDto dto = new MemberDto();
		String query = "SELECT * FROM member WHERE id=? AND pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1,uid);
			psmt.setString(2,upw);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
		
	}
	
}
