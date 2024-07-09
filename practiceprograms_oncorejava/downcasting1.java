
class Base
{
    int a=100;
    static int s=200;
    static void  fun()
    {
      System.out.println("base class static method is called ....");
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
public class downcasting1
{
  public static void main(String[] args) {
    Base b=new child();
    ((child)b).display();
    
  }
}