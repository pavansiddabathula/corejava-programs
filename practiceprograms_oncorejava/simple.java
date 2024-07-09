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
        System.out.println("the base class ");
        System.out.println("the value of a is:"+a);
        System.out.println("the value of b is :"+b);
    }

}
class child extends Base//child class extends the base class 
{
    child()//child class constructor 
    {
        //System.err.println("child constructor :");
        super(10,20);//super constructor 
    }
}
public class simple{
    public static void main(String[] args) {
        child c=new child() ;//object creation for child class 
        c.display();//method calling by using child class object 
        
        
    }
}