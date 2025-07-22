package JDBCDemo;

import java.sql.*;

import com.mysql.cj.xdevapi.Statement;

 

public class bank {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		  String url = "jdbc:mysql://localhost:3306/jan25_jdbc";
	      String username =  "root";
	      String password = "Ashwini@7899";
	      
	      String sql = "INSERT INTO kod_student values(?,?)";
	      
	      Connection con = DriverManager.getConnection(url,username,password);
	      con.setAutoCommit(false);
	      java.sql.Statement st = con.createStatement();
	      st.executeUpdate(sql);
	      
	}

}
