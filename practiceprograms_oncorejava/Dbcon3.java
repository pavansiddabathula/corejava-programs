import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Dbcon2 {
    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully...");

        // Establish connection to the database
        String url = "jdbc:mysql://localhost:3306/javadb"; // URL format: jdbc:mysql://host:port/database
        String username = "root";
        String password = "gopi";
        
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully.");

        // Create a statement object to execute SQL queries
        Statement statement = connection.createStatement();
        
        // Create a table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "email VARCHAR(100) NOT NULL)";
        statement.executeUpdate(createTableSQL);
        System.out.println("Table created successfully.");

        // Insert a record
        String insertSQL = "INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com')";
        statement.executeUpdate(insertSQL);
        System.out.println("Record inserted successfully.");

        // Query the table
        String selectSQL = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(selectSQL);
        
        // Process the result set
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
        }
        
        // Close the resources
        resultSet.close();
        statement.close();
        connection.close();
        System.out.println("Connection closed.");
    }
}
