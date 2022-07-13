import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        int dp[][] = new int[n+1][n+1];
        int lengthOfRod[] = new int[n];
        
        for(int i = 0; i<n; i++)
        {
            lengthOfRod[i] = i+1;
        }
        
        
        //Base Case
        
        for(int i = 0; i<=n;i++)
        {
            for(int j = 0; j<=n; j++)
            {
                if(i == 0 || j == 0)
                dp[i][j] = 0;
            }
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1; j<=n; j++)
            {
                
                int not_pick = 0+ dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                
                if(lengthOfRod[i-1]<=j)
                {
                    pick = price[i-1] + dp[i][j-lengthOfRod[i-1]];
                }
                
                dp[i][j] = Math.max(pick,not_pick);
            }
        }
        
        return dp[n][n];
    }
}
