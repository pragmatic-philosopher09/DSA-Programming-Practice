import java.io.*;
import java.util.*;

class NumberOfPositiveIntegralSolutions
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.posIntSol(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long factorial(int n)
    {
        long fact = 1;
        
        for(int i=1;i<=n;i++)
        {
            fact*=i;
        }
        return fact;
    }
    long posIntSol(String s)
    {
        //code here.
        
        int countOfVariables = 1,index=0;
        long numerator=1,denominator;
        for (int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='+')
            countOfVariables++;
            
            if(s.charAt(i)=='=')
            index=i;
        }
        
        int K = Integer.parseInt(s.substring(index+1));
        K--;
        countOfVariables--;
        
        for(int j= 0; j<countOfVariables;j++)
        {
            numerator*=K;
            K--;
        }
        
        denominator = factorial(countOfVariables);
        long ans = numerator/denominator;
    
        return ans;
    }
}
