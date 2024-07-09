import java.util.*;
import java.sql.*;
//import java.sql.ResultSet;
public class jdbcown1 {
    public static void main(String[] args)throws Exception {
        Scanner s = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/javadb";
        String username="root";
        String password="";
        Connection con=DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?)");
        try{
        while(true){
            System.out.println("Enter Roll Number :");
            int roll_no=s.nextInt();
            System.out.println("Enter the Student Name:");
            String name=s.next();
            System.out.println("Enter the student Age:");
            int age=s.nextInt();
            pstmt.setInt(1,roll_no);
            pstmt.setString(2,name);
            pstmt.setInt(3,age);
            int r=pstmt.executeUpdate();
            System.out.println(+r+"row inserted succefully");
            System.out.println("do yow want insert again :Y/N");
            String opt=s.next();
            if(opt == "N")
                break;
        }
    }
    catch(Exception e){
        throw new Exception("Roll number already exists");
    }
    
        Statement stm=con.createStatement();
        String sql="Select * from student";
        ResultSet rst=stm.executeQuery(sql);
        while(rst.next())
        {
            System.out.printf("%-5d  %-30s %n" ,rst.getInt(1),rst.getString(2));
        }
        rst.close();
        pstmt.close();
        con.close();
        System.out.println("connection close");
        
    }
    
}
