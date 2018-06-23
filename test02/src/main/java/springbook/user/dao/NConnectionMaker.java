package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");		
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "tiger");
	}

}
