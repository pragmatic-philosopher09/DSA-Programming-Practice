import java.util.*;

public class NearestLeftElement {

    static List LesserElement(int n, int a[])
    {
        List<Integer> l = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int i;

        for(i=0;i<n;i++)
        {
            while(!s.isEmpty() && s.peek()>=a[i])
            {
                s.pop();
            }

            if(s.isEmpty())
            {
                l.add(-1);
            }

            else{
                l.add(s.peek());
            }
            s.add(a[i]);
        }
        return l;
    }

        static List GreaterElement (int n, int a[])
        {
            List<Integer> l = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int i;

        for(i=0;i<n;i++)
        {
            while(!s.isEmpty() && s.peek()<=a[i])
            {
                s.pop();
            }

            if(s.isEmpty())
            {
                l.add(-1);
            }

            else{
                l.add(s.peek());
            }
            s.add(a[i]);
        }

        return l;
    }

     public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n,i;
        System.out.println("Enter Size of Array ==> ");
        n = in.nextInt();
        int a[] = new int[n];

        System.out.println("Enter Array Elements ==> ");
        for(i=0;i<n;i++)
        {
            a[i] = in.nextInt();
        }

        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        
        num1 = LesserElement(n, a);
        num2 = GreaterElement(n, a);

        System.out.println("Greater Elements On Left Side ==> "+num1);
        System.out.println("Lesser Elements On Left Side ==> "+num2);

        
    }
    
}
