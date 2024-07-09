import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbcon23 {
    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully...");

        // Establish connection to the database
        String url = "jdbc:mysql://localhost:3306/javadb"; // URL format: jdbc:mysql://host:port/database
        String username = "root"; // Default XAMPP MySQL username
        String password = ""; // Default XAMPP MySQL password is empty
        
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully.");

        // Create a statement object to execute SQL queries
        Statement statement = connection.createStatement();
        
        // Query the table
        String insertSQL = "INSERT INTO student (roll_no, name, age) VALUES (5, 'John Doe', 20)";

        boolean b= statement.execute(insertSQL);
        if(b==true)
        {
            ResultSet Rst=statement.getResultSet();
             while (Rst.next()) {
                int rollNo = Rst.getInt("roll_no");
                String name = Rst.getString("name");
                int age = Rst.getInt("age");
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Age: " + age);
            }
            Rst.close();
        }
        System.out.println("Inserted succefully....");
        statement.close();
        connection.close();
        System.out.println("Connection closed.");
    }
}
