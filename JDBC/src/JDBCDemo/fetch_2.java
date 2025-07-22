package JDBCDemo;

import java.sql.*;

public class fetch_2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/jan25_jdbc";
        String username = "root";
        String password = "Ashwini@7899";
        
        String sql = "CALL GetBank('Virat')";
        Connection con = DriverManager.getConnection(url,username,password);
        
        CallableStatement cs = con.prepareCall(sql);
        ResultSet rs = cs.executeQuery();
        rs.next();
        System.out.println(rs.getString(1) +  " - " + rs.getInt(2));
	}

}
