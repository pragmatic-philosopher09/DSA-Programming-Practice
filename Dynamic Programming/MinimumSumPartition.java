import java.io.*;
import java.util.*;
class MinimumSumPartition
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    int totalSum = 0;
	    
	    for(int i = 0; i<n;i++)
	    {
	        totalSum += arr[i];
	    }
	    
	    boolean dp[][] = new boolean[n+1][totalSum+1];
	    
	    //Base Case
	    
	    for(int i=0;i<n;i++)
	    {
	        dp[i][0] = true; //when target sum is '0' fill true, means we've reached target
	    }
	    
	    for(int i = 1; i<=n;i++)
	    {
	        for(int j = 1; j<=totalSum; j++)
	        {
	            boolean notpick = dp[i-1][j];
	            boolean pick = false;
	            
	            if(j>=arr[i-1])
	            {
	                pick = dp[i-1][j-arr[i-1]];
	            }
	            
	            dp[i][j] = pick || notpick;
	        }
	    }
	    
	    int minSum = (int)1e9;
	    
	    for(int sumofSubset1 = 0; sumofSubset1<=totalSum;sumofSubset1++)
	    {
	        if(dp[n-1][sumofSubset1])
	        {
	            minSum = (int)Math.min(minSum, Math.abs(sumofSubset1-(totalSum-sumofSubset1)));
	        }
	    }
	    
	    return minSum;
	    
	} 
}

