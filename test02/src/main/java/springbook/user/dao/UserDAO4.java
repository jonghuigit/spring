package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.UserVO;

public class UserDAO4 {
	private ConnectionMaker connectionMaker; 
	
	public UserDAO4() {
		connectionMaker = new NConnectionMaker();
	}
	
	public UserDAO4(ConnectionMaker useConnectionMaker) {
		this.connectionMaker = useConnectionMaker;
	}
	
	public void add(UserVO user) throws ClassNotFoundException, SQLException {	// insert
		Connection con = connectionMaker.getConnection();

		PreparedStatement pstmt = con.prepareStatement("insert into users values (?,?,?)");
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public UserVO get(String id) throws ClassNotFoundException, SQLException {	// select 1 row
		Connection con = connectionMaker.getConnection();
		
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
