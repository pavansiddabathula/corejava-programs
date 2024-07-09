import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class jdbc5
{
    public static void main(String []args)throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/javadb";
        String username="root";
        String password="";
        Connection con=DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?)");
        pstmt.setInt(1,6);
        pstmt.setString(2, "pavankumarsharavath");
        pstmt.setInt(3, 23);
        int r=pstmt.executeUpdate();
        System.out.println("%d row inserted"+r);
    }
}   

