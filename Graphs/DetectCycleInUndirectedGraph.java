import java.util.*;
import java.lang.*;
import java.io.*;
class DetectCycleInDirectedGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends



class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        boolean visited[] = new boolean[V];
        
        for (int i=0; i<V;i++)
        {
            if(!visited[i])
            {
        if(dfsTraversalForCycleCheck(visited, adj, i, -1))
        return true;
    }
        }
    
    return false;
    }
    
    boolean dfsTraversalForCycleCheck(boolean visited[], ArrayList<ArrayList<Integer>> adj, int presentV, int parent)
    {
        
        visited[presentV] = true;
        
        for (Integer neighbour: adj.get(presentV))
        {
            if(!visited[neighbour])
            {
                if(dfsTraversalForCycleCheck(visited, adj, neighbour, presentV))
                {
                    return true;
                }
            }
            
            else if(parent != neighbour)
            return true;
        }
        
        return false;
    }
}
