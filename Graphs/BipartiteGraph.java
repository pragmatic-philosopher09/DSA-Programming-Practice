import java.util.*;
import java.lang.*;
import java.io.*;
class BipartiteGraph
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        int colour[] = new int[V];
        
        for(int i = 0; i < V; i++)
        {
            if(colour[i]==0)
            {
            colour[i]=1;
            if(!dfsTraversalForColouring(i,colour,adj))
            return false;
        }
        }
        
        return true;
    
    }
    
    static boolean dfsTraversalForColouring(int vertex, int colour[], ArrayList<ArrayList<Integer>> adj)
    {
        for (Integer neighbour: adj.get(vertex))
        {
            if(colour[neighbour]==colour[vertex])
            return false;
            
            else if (colour[neighbour] == 0)
            {
                colour[neighbour] = (colour[vertex]==1)?2:1;
                
                if (!dfsTraversalForColouring(neighbour,colour,adj))
                return false;
            }
        }
        
        return true;
    }
    
}
