package Student_Project;

import java.sql.*;
import java.util.Scanner;

public class student_data {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		  String url = "jdbc:mysql://localhost:3306/jan25_jdbc";
	      String username =  "root";
	      String password = "Ashwini@7899";
	     
	      
	      String sql = "INSERT INTO kod_student values(?,?)";
	      Connection con = DriverManager.getConnection(url,username,password);
	     
	      System.out.println("Enter data to be inserted: ");
	      int n = sc.nextInt();
	      for(int i=0;i<n;i++) {
	    	   System.out.println("Enter roll number: ");
		       int roll = sc.nextInt();
		      
		      System.out.println("Enter name: ");
		      String name = sc.next();
		     
	    
	      PreparedStatement ps = con.prepareStatement(sql);
		  ps.setInt(1, roll);
		  ps.setString(2, name);
	      
	      ps.executeUpdate();
	    }
	}

}
