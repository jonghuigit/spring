package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.UserVO;

public class UserDAO {
	public void add (UserVO user) throws ClassNotFoundException, SQLException {	// insert
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "tiger");
		
		PreparedStatement pstmt = con.prepareStatement("insert into users values (?,?,?)");
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public UserVO get(String id) throws ClassNotFoundException, SQLException {	// select 1 row
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "tiger");
		
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
}
