import java.util.*;
import java.sql.*;
//import java.sql.ResultSet;
public class jdbcown {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/javadb";
        String username="root";
        String password="";
        Connection con=DriverManager.getConnection(url,username,password);
        String sql="select * from student";
        Statement stmt=con.createStatement();
        boolean b=stmt.execute(sql);
        if (b)
        {
            System.out.println(b);
            ResultSet rst=stmt.executeQuery(sql);
            while(rst.next())
            {
                System.out.printf("%-5d  %-30s %n" ,rst.getInt(1),rst.getString(2));
            }
            rst.close();
        }
        stmt.close();
        con.close();
        System.out.println("connection close");



        
    }
    
}
