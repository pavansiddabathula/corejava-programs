class Base
{
    int a=100;
    static int s=200;
    static void  fun()
    {
      System.out.println("base class static method is called ....");
    }
    void display()
    {
        System.out.println("display method in base class...");
    }
    void display1()
    {
        System.out.println("display2 method in base class...");
    }
}
class child extends Base{
    int a=1000;
    static int s=2000;
    static void  fun()
    {
      System.out.println("Child class static method is called ....");
    }
    void display()
    {
        System.out.println("display method in Child class...");
    }

}
public class upcastingex
{
  public static void main(String[] args) {
    Base b=new child();
    System.out.println(b.a);
    System.out.println(b.s);
    b.fun();
    b.display();
    b.display1();
    
  }
}