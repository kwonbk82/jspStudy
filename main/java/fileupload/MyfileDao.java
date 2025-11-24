package fileupload;

import java.util.ArrayList;
import java.util.List;

import common.JDBC_connect;
import jakarta.servlet.ServletContext;

public class MyfileDao extends JDBC_connect{
	public MyfileDao(ServletContext application) {
		super(application);
	}
	public int insertFile(MyfileDto dto) {
		int applyResult =0;
		try {
			String query = "INSERT INTO myfile(name,title,cate,ofile,sfile)"+"VALUES(?,?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			
			applyResult = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	
	public List<MyfileDto> myFileList(){
		List<MyfileDto> fileList = new ArrayList<>();
		String query = "SELECT * FROM myfile ORDER BY idx DESC";
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				MyfileDto dto = new MyfileDto();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdate(rs.getString(7));
				
				fileList.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("목록 조회시 예외발생");
			e.printStackTrace();
		}
		return fileList;
	}
}
