import java.util.*;
import java.io.*;
import java.lang.*;

class MinimumSpanningTreeUsingPrimsAlgo
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

class Pair implements Comparable<Pair>
{
    int v; int wt;
    
    public Pair(int v, int wt)
    {
        this.v = v; //Dest. Vertex
        this.wt = wt; //Weight of Edge Between Vertices
    }
    
    public int compareTo(Pair that)
    {
        return this.wt - that.wt; // This is used to sort Priority Queue's Pair On The Basis of Weights
    }
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        
        boolean visited[] = new boolean[V];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        q.add(new Pair(0,0));
        
        int sumw = 0;
        
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            
            int u = curr.v;
            
            if (visited[u])
            continue;
            
            sumw += curr.wt;
            visited[u] = true;
            
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            
            for(ArrayList<Integer> list: neighbours)
            {
                int vertex = list.get(0);
                int weight = list.get(1);
                
                if(!visited[vertex])
                {
                    q.add(new Pair(vertex,weight));
                }
        }
        }
        
       return sumw;
    }
}
