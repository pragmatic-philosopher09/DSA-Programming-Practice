public class Q {
    int a;
    

    int f(int b)
    {
        if(b==0)
        return 0;

        else{
            System.out.println(a);
            b--;
        }
        return b;
    }
    public static void main(String[] args)
    {
        Q obj = new Q();
        int a= obj.f(10);
        System.out.println(a);
    }
    
}
