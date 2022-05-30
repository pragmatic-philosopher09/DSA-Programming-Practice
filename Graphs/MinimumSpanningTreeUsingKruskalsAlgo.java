import java.util.*;
import java.io.*;
import java.lang.*;

class MinimumSpanningTreeUsingKruskalsAlgo
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Edge implements Comparable<Edge>
{
    int src;
    int dest;
    int wt;
    
    public Edge(int src, int dest, int wt)
    {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    
    public int compareTo(Edge that)
    {
        return this.wt-that.wt;
    }
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int parent[];
    static int find(int x)
    {
        if(parent[x]==x)
        return x;
        
        return find(parent[x]);
    }
    
    static void union(int x, int y)
    {
        int rx = find(x);
        int ry = find(y);
        
        if(rx == ry)
        return;
        
        parent[ry] = rx;
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        boolean added[][] = new boolean[V][V];
        
        int i,j, count=1, res=0;
        ArrayList<Edge> edges = new ArrayList<>();
        for(i = 0; i<adj.size();i++)
        {
            for(j=0;j<adj.get(i).size();j++)
            {
                ArrayList<Integer> curr = adj.get(i).get(j);
                if(!added[i][curr.get(0)])
                {
                    added[i][curr.get(0)] = true;
                    added[curr.get(0)][i] = true;
                    
                    edges.add(new Edge(i, curr.get(0), curr.get(1)));
                }
            }
        }
        
        parent = new int[V];
        
        for(i = 0; i <V;i++)
        {
            parent[i]=i;
        }
        
        Collections.sort(edges);
        
        for(i = 0; count < V; i++)
        {
            Edge edge = edges.get(i);
            int rx = find(edge.src);
            int ry = find(edge.dest);
            
            if(rx != ry)
            {
                union(rx,ry);
                count++;
                res += edge.wt;
            }
        }
    
    
    return res;
}
}
