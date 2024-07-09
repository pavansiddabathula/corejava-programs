abstract class base
{
    abstract void add(int a,int b);
    void sub(int a ,int b)
    {
        System.out.printf("sub is:%d\n",(a-b));
    }
}
class child extends base
{
    void add(int a ,int b)
    {
       System.out.printf("The sum is %d \n",(a+b));
    }
}
public class abstract11{
    public static void main(String []args)
    {
         base b= new child();
         b.add(7,8);
         b.sub(6, 8);
    }

}