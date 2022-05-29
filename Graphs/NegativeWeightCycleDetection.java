import java.util.*;
import java.lang.*;
import java.io.*;
class NegativeWeightCycleDetection
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        
        int cos[] = new int[n];
        Arrays.fill(cos, Integer.MAX_VALUE);
        
        cos[0] = 0;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < edges.length; j++)
            {
                int src = edges[j][0];
                int dest = edges[j][1];
                int cost = edges[j][2];
                
                if(cos[src] != Integer.MAX_VALUE && cost+cos[src] < cos[dest])
                {
                    cos[dest] = cos[src]+cost;
                }
            }
        }
        
        for (int j = 0; j < edges.length; j++)
            {
                int src = edges[j][0];
                int dest = edges[j][1];
                int cost = edges[j][2];
                
                if(cos[src] != Integer.MAX_VALUE && cost+cos[src] < cos[dest])
                {
                    return 1;
                }
            }
            
        return 0;
    }
}
