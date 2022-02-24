import java.io.*;
import java.util.*;

public class ReturnTwoPrimes{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean isPrime(int n)
    {
        if(n==1)
        return false;
        
        if(n==2||n==3)
        {
            return true;
        }
        
        if(n%2==0)
        {
            return false;
        }
        
        for(int i=3;i<=Math.sqrt(n);i+=2)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    
    static List<Integer> primeDivision(int N){
        // code here
        
        List<Integer> an = new ArrayList<>();
        if(N==3)
        {
            an.add(1);
            an.add(3);
            return an;
        }
        
        if(isPrime(N-2))
        {
            an.add(2);
            an.add(N-2);
            return an;
        }
        
        for(int i=3;i<N;i+=2)
        {
            if(isPrime(i))
            {
                if(isPrime(N-i))
                {
                    an.add(i);
                    an.add(N-i);
                    break;
                }
            }
        }
        
        return an;
    }
}