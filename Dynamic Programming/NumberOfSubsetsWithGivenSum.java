import java.io.*;
import java.util.*;
class NumberOfSubsetsWithGivenSum
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    int dp[][] = new int[n+1][sum+1];
	  
	    
	    for(int i = 0; i<=n;i++)
	    {
	        for(int j = 0; j<=sum;j++)
	        {
	            if(i==0)
	            dp[i][j] = 0;
	            
	            if(j==0)
	            dp[i][j] = 1;
	        }
	    }
	    
	    
	    
	   
	    
	    for(int i=1; i<=n;i++)
	    {
	        for(int j=0; j<=sum; j++)
	        {
	            int pick = 0;
	            int notpick = dp[i-1][j]%1000000007;
	            
	            if(j>=arr[i-1])
	            {
	                pick = dp[i-1][j-arr[i-1]]%1000000007;
	            }
	            
	            dp[i][j] = (pick+notpick);
	        }
	    }
	    
	    return dp[n][sum]%1000000007;
	    
	} 
}
