class HousePlan
{
    static String city;
    byte kn;
    short pr;
    int br1,br2;
    static
    {
        System.err.println("x:static block anniya .....");
        city="vijayawada";
    }
    //instance
    {
        System.err.println("edhi instance lock gopi annyaa...");
    }
    HousePlan()//construcctor
    {
         //super()
         System.out.println("instance block statement annya ");
         System.out.println("edhi constructor annyaay");
         kn=0;
         pr=0;
         br1=0;
         br2=0;
    }
    void HousePlan()//instance method 
    {
        System.out.println("instance method brooo.....");

    }
    void watch()//instancce method 
    {
        System.out.println("edho instance block ");
    }
    static void fun1()//static method 
    {
        System.out.println("edhi static method annayya.......");
    }


}
public class One //main class 
{
    public static void main(String []Args)
    {
        HousePlan p1=new HousePlan();//object creation 
        System.out.println(p1.kn);
        System.out.println(p1.pr);
        System.out.println(p1.br1);
        System.out.println(p1.br2);
    }
}