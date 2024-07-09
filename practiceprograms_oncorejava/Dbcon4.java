import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Dbcon4
{
    public static void main(String []args)throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/javadb";
        String username="root";
        String password="";
        Connection con=DriverManager.getConnection(url,username,password);

        Statement stm=con.createStatement();
        String sql="Select* from student";
        boolean rst=stm.execute(sql);
        if(rst)
        {
            System.out.println("inserted succefully ....");
        }
       

    } 
}

