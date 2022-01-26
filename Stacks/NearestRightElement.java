import java.util.*;
public class NearestRightElement {

    static long[] LesserElement(int n, long arr[])
    {
        long res[] = new long[n];
        int k=1;
        Stack<Long> s = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()>=arr[i])
            {
                s.pop();
            }
            
            if(s.isEmpty())
            {
                res[n-k]=-1;
                k++;
            }
            else
            {
                res[n-k]=s.peek();
                k++;
            }
            s.add(arr[i]);
        }
        return res;
    }

    static long[] GreaterElement(int n, long arr[])
    {
        long res[] = new long[n];
        int k=1;
        Stack<Long> s = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()<=arr[i])
            {
                s.pop();
            }
            
            if(s.isEmpty())
            {
                res[n-k]=-1;
                k++;
            }
            else
            {
                res[n-k]=s.peek();
                k++;
            }
            s.add(arr[i]);
        }
        return res;
    }

    
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int n,i;
            System.out.println("Enter Size of Array ==> ");
            n = in.nextInt();
            long a[] = new long[n];
    
            System.out.println("Enter Array Elements ==> ");
            for(i=0;i<n;i++)
            {
                a[i] = in.nextLong();
            }
    
            
            
            long num1[] = new long[n];
            long num2[] = new long[n];
            num1 = LesserElement(n, a);
            num2 = GreaterElement(n, a);
    
            
    
            
        }
    }
    

