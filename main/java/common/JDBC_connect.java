package common;

import java.sql.*;

import jakarta.servlet.ServletContext;

public class JDBC_connect {
	public Connection con;
	public Statement stmt; //매개변수가 없는 정적쿼리
	public PreparedStatement psmt; //매개변수가 있는 동적쿼리
	public ResultSet rs;
	
	public JDBC_connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//프로토콜://ip주소:포트번호/db명?옵션
			//옵션 : serverTimezone=UTC -> 표준시간대로 설정
			//useUnicode=true, characterEncoding=utf8 -> 한글깨짐 방지
			String url = "jdbc:mysql://localhost:3306/studyjsp?"
									+ "serverTimezone=UTC&useUnicode=true"
									+ "&characterEncoding=utf8";
			String id="root";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public JDBC_connect(String driver,String url,String id,String pw) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
			while(rs.next()){
				String id1 = rs.getString(1);
				String pw1 = rs.getString(2);
				String name = rs.getString("name");
				Date regidate = rs.getDate("regidate");
				
				out.println(String.format("%s %s %s %s",id1,pw1,name,regidate)+"<br>");
			}
			jdbc.close();
			System.out.println("DB 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBC_connect(ServletContext application) {
		try {
			Class.forName(application.getInitParameter("MySqlDriver"));
			String url = application.getInitParameter("MySqlURL");
			String id = application.getInitParameter("MySqlId");
			String pw = application.getInitParameter("MySqlPw");
			
			
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
