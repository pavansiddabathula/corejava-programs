import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class jdbc6
{
    public static void main(String []args)throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/javadb";
        String username="root";
        String password="";
        Connection con=DriverManager.getConnection(url,username,password);
        Scanner scan=new Scanner(System.in);
        PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?)");
        do{
            System.out.println("Ennter student Roll no:\t");
            int roll_no=scan.nextInt();
            System.out.println("Enter the name of the student:\t");
            String name=scan.next();
            System.out.println("Enter the Age:\t");
            int age=scan.nextInt();
            try{
            pstmt.setInt(1,roll_no);
            pstmt.setString(2, name);
            pstmt.setInt(3,age);
            int r=pstmt.executeUpdate();
            System.out.println("%d row inserted"+r);
            System.out.println("do you want inster again then choose 1 or 0:\t");
            int opt=scan.nextInt();
            if (opt==0)
              break;
            }
            catch(Exception e)
            {
                throw new Exception("roll no is unqique");
            }  

        }while(true);
        String sql="select * from student";
        Statement stmt = con.createStatement();
        ResultSet rst=stmt.executeQuery(sql);
        while(rst.next())
        {
            System.out.println("Roll No:\t"+rst.getInt("roll_no")+"name:\t"+rst.getString("name")+"Age:\t"+rst.getInt("age"));
        }
        rst.close();
        pstmt.close();
        con.close();
        System.out.println("connection closed");


    }
}   

