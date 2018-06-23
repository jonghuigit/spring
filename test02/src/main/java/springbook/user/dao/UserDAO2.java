package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.UserVO;

public class UserDAO2 {
	public void add (UserVO user) throws ClassNotFoundException, SQLException {	// insert
		Connection con = getConnection();

		PreparedStatement pstmt = con.prepareStatement("insert into users values (?,?,?)");
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public UserVO get(String id) throws ClassNotFoundException, SQLException {	// select 1 row
		Connection con = getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("select * from users where id = ?");
		
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		UserVO user = null;
		
		while(rs.next()) {
			user = new UserVO();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
	}
	
	// DAO의 분리 = 모듈화
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");		
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "tiger");
	}
}
