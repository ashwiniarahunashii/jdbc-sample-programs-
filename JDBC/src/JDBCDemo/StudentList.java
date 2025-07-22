package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentList {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      
      System.out.println("Enter KODid: ");
      int id = sc.nextInt();
      sc.nextLine();
      
      System.out.println("Enter name: ");
      String name = sc.next();
      
      sc.nextLine();
      System.out.println("Enter Address: ");
      String add = sc.nextLine();
      
      System.out.println("Enter yop: ");
      int yop = sc.nextInt();
      
      
   
      String url = "jdbc:mysql://localhost:3306/JDBC";
      String username =  "root";
      String password = "Ashwini@7899";
      
      String sql = "INSERT INTO studentlist values(?,?,?,?)";
      
      Connection con = DriverManager.getConnection(url,username,password);
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ps.setString(2, name);
      ps.setString(3,add);
      ps.setInt(4, yop);
      
      
      int res = ps.executeUpdate();
      System.out.println(res + "Inserted successfully");
      sc.close();
   	}

}
