import java.util.*;
import java.lang.*;
import java.io.*;
class SpecialMatrix
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        
        int arr[][] = new int[n][m];
        int dp[][] = new int[n][m];
        int i,j;
        
         int mod=1000000007;
         
        for(i = 0; i<blocked_cells.length;i++)
        {
            for(j=0; j <2; j++)
            {
                int x = blocked_cells[i][0]-1;
                int y = blocked_cells[i][1]-1;
                
                arr[x][y] = -1;
            }
        }
        
        for(i = 0; i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(arr[i][j] == -1)
                {
                    dp[i][j] = 0;
                }
                
                else if((i==0) && (j==0))
                {
                    dp[i][j] = 1;
                }
                
                else
                {
                    int up = 0, left = 0;
                    
                    if(i>0)
                    {
                        up = dp[i-1][j];
                    }
                    
                    if(j>0)
                    {
                        left = dp[i][j-1];
                    }
                    
                    dp[i][j] = up+left; 
                }
            }
        }
        
        return dp[n-1][m-1]%mod;
    }
}
