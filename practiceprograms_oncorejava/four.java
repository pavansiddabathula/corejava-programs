class one {
    int a,b;
    one(int a, int b)
    {
        this.a=a;
        this.b=b;
    }
    void display()
    {
        System.out.println("Object State :");
        System.out.println("a="+a);
        System.out.println("b="+b);

    }
}
    public class four {
        public static void main(String[] args) {
            one o1=new one(10,20);
            o1.display();

            one o2=new one(100,200);
            o2.display();
        }
 }