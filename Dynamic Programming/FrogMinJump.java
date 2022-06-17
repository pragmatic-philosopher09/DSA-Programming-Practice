import java.util.*;
import java.io.*;
import java.lang.*;

class FrogMinJump
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of steps in stair
            int n = sc.nextInt();
            
            //calling method countWays() of class Hops
            System.out.println(new Solution().countWays(n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // add your code here
        
        if(n<=2)
        return n;
        
        long dp[] = new long[n+1];
        
        
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        
       
        
        int mod=(int)1e9+7;
        
        for(int i=4; i <= n;i++)
        {
            dp[i] = (dp[i-1]%mod+dp[i-2]%mod+dp[i-3]%mod)%mod;
        }
        
        return dp[n];
    }
    
}

