package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertIntoSQL {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jan25_jdbc";
        String username = "root";
        String password = "Ashwini@7899";

//        String sql =  "INSERT INTO kod_student VALUES (10,'Ashwini'),(11, 'Lvanya'),(13,Kushboo),(14,'Gopica')";
          String sql =  "INSERT INTO kod_student VALUES (13,'Kushboo'),(14,'Gopica')";

        try {
            // Step 1: Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 2: Create Statement
            Statement st = con.createStatement();

            // Step 3: Execute Query
            int result = st.executeUpdate(sql);
            System.out.println(result + " row(s) inserted");

            // Step 4: Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
