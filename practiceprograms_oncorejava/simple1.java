class Base//base class 
{
    int a,b;
    Base(int a,int b)//base class constructor 
    {
        System.out.println("The base parameterised constructor ");
        this.a=a;
        this.b=b;
    }
    void display()
    {
        System.out.println("the base class display method ");
        System.out.println("the value of a is:"+a);
        System.out.println("the value of b is :"+b);
    }

}
class child extends Base//child class extends the base class 
{
    int c,d;
    child(int c,int d)//child class constructor 
    {
        //System.err.println("child constructor :");
        super(10,20);//super constructor 
        this.c=c;
        this.d=d;
    }
    void display2()
    {
        System.out.println("the child class display method ");
        System.out.println("the value of a is:"+c);
        System.out.println("the value of b is :"+d); 
    }
}
public class simple1{
    public static void main(String[] args) {
        child c=new child(100,200);//object creation for child class 
        c.display();//method calling by using child class object
        c.display2();
        
        
    }
}