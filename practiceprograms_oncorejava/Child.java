class Base
{
    int a;
    Base()
    {
        //Super()
         System.out.println("Basr classs");
         a=0;
    }
}
class Child extends Base
{
    public static void main(String []Args)
    {
        Base c1=new Child();
        System.out.println(c1.a);


    }
}