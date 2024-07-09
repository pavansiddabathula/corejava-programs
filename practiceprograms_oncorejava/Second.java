 class one
{
    static int count ;
    int a,b;
    static
    {
        count=0;
    }
    one()
    {
        //Super()
        //a=0;
        //b=0;

    }
}   
public class Second{
        public static void main(String []Args)
        {
            Object foo = new Object();
             s1= new one();
            System.out.println(s1.a);
            System.out.println(s1.b);

            Second s2= new one();
            System.out.println(s2.a=100);
            System.out.println(s2.a=200);

            Second s3=new one();
            System.out.println(s2.a=300);
            System.out.println(s2.b=400);
            


        }
}