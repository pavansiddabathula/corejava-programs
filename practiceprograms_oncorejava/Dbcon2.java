import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbcon2 {
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
        String selectSQL = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(selectSQL);
        
        // Process the result set
        while (resultSet.next()) {
            int rollNo = resultSet.getInt("roll_no");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Age: " + age);
        }
        
        // Close the resources
        resultSet.close();
        statement.close();
        connection.close();
        System.out.println("Connection closed.");
    }
}
