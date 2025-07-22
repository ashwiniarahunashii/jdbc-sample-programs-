package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insertDataFromUser {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      
      System.out.println("Enter roll: ");
      int roll = sc.nextInt();
      
      System.out.println("Enter name: ");
      String name = sc.next();
      
   
      String url = "jdbc:mysql://localhost:3306/jan25_jdbc";
      String username =  "root";
      String password = "Ashwini@7899";
      
      String sql = "INSERT INTO kod_student values(?,?)";
      
      Connection con = DriverManager.getConnection(url,username,password);
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, roll);
      ps.setString(2, name);
      
      ps.executeUpdate();
      sc.close();
   	}

}
