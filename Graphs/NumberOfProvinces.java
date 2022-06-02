import java.io.*;
import java.util.*;

class NumberOfProvinces {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void dfsTraversal(boolean visited[], ArrayList<ArrayList<Integer>> adj, int v, int V)
    {
        visited[v] = true;
        
        for (int j = 0; j < V; j++)
        {
            if(!visited[j] && adj.get(v).get(j) == 1 )
            {
                dfsTraversal(visited, adj, j, V);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean visited[] = new boolean[V];
        
        int numOfProvinces = 0;
        
        for (int i = 0; i < V; i++)
        {
            for(int j = 0; j <V; j++)
            {
            if(!visited[j])
            {
                numOfProvinces++;
                dfsTraversal(visited, adj, j,V);
            }
        }
        }
        
        return numOfProvinces;
    }
};
