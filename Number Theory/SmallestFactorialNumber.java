//Initial Template for Java

import java.util.*;

public class SmallestFactorialNumber
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static int numOfZeroesInFactorial(int x)
    {
       int denom = 5;
        int zeroes=0;
        while(x>=denom)
        {
            zeroes+= (x/denom);
            denom*=5;
        }
        return zeroes;
    }
    int findNum(int n)
    {
        // Complete this function
        
        int low = 0;
        int high = (5*n);
        int res = 0;
        
        //Binary Search
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            int zeroes = numOfZeroesInFactorial(mid);
            
            if(zeroes>=n)
            {
                res = mid;
                high = mid-1;
                
            }
            
            else
            low = mid+1;
        }
        
        return res;
    }
}
