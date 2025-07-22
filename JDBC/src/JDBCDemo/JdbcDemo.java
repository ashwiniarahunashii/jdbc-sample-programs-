  package JDBCDemo;

import java.sql.*;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/jan25_jdbc";
		String username = "root";
		String password = "Ashwini@7899";
		
		//establish connection
		Connection conn = DriverManager.getConnection(url,username,password);
		System.out.println(conn);     
	}

}
