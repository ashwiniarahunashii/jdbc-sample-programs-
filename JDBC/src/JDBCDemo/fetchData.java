package JDBCDemo;

import java.sql.*;

public class fetchData {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/jan25_jdbc";
        String username = "root";
        String password = "Ashwini@7899";
        
        String sql = "Select * from bank";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()) {
        	System.out.println(rs.getString(1) + " - " + rs.getInt(2));
        }
	}

}
