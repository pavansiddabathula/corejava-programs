import java.util.*;
import java.sql.*;
import java.util.Scanner;
class Dao
{  
    public Scanner scan=new Scanner(System.in);
    Connection con;
    Dao()throws ClassNotFoundException,SQLException//connection establishing baby
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","");
    }
    void insert()throws Exception//insertion process baby.
    {
        PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?)");
        while(true)//for multiple insertions 
        {
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
            catch(Exception e)//to handle unique roll no exception
            {
                throw new Exception("roll no is unqique");
            }  

        }
    }
    void update()throws Exception//for update method baby
    {
        try
        {
                System.out.println("Enter the new name :");
                String name=scan.next();
                System.out.println("Enter roll number:");
                int roll_no=scan.nextInt();
                String cmd="update student set name=? where roll_no=?";
                PreparedStatement pstmt=con.prepareStatement(cmd);
                pstmt.setString(1,name);
                pstmt.setInt(2,roll_no);
                int r=pstmt.executeUpdate();
                if(r==1)
                {
                System.out.println("updated....");
                }   
                else
                {
                System.out.println("updation failed...");
                } 
        }
        catch(Exception e){//if the given roll is not present in db then throws exception
            throw new Exception("Roll number doesn't exist ");
        }
    }
    void view()throws Exception//to retriev the data present in the table 
    {
        String sql="select * from student";
        Statement stmt = con.createStatement();
        ResultSet rst=stmt.executeQuery(sql);
        while(rst.next())
        {
            System.out.println("Roll No:"+rst.getInt("roll_no")+"\tname:"+rst.getString("name")+"\tAge:"+rst.getInt("age"));
        }
        rst.close();
    }
    void delete()throws Exception//for deletions baby 
    {
        System.out.println("Enter the roll no for delete from db:");
        int roll_no=scan.nextInt();
        String cmd="delete from student where roll_no=?";
        PreparedStatement pstmt=con.prepareStatement(cmd);
        pstmt.setInt(1,roll_no);
        int r=pstmt.executeUpdate();
        if(r==1)
        {
           System.out.println("deleted succefully");
        }   
        else
        {
           System.out.println("deletion fail...");
        }  
    }
}
public class jdbcdoa{
    public static void main(String[] args) throws ClassNotFoundException,SQLException
    {
        Scanner scan=new Scanner(System.in);
        Dao d1=new Dao();
        while (true)
         {
            System.out.println("Enter 1.for insertion 2.for update 3.view data 4.deletion 5.exit");
            int s=scan.nextInt();
            try{
                if (s==1)
                {
                    d1.insert();
                }
                else if(s==2)
                {
                    d1.update();
                }
                else if(s==3)
                {
                    d1.view();
                }
                else if(s==4)
                {
                    d1.delete();
                }
                else if(s==5)
                { 
                    d1.con.close();
                    System.out.println("connection closed");
                    break;
                } 
                else{
                    System.out.println("Enter correct option");
                }
            }     
            
            catch(Exception e)   
            {
                System.out.println("Error: " + e.getMessage());
            }
        }    
    }   
}
