import java.io.*;
import java.util.*;
import java.lang.*;

class CircleOfStringsEulerianGraph
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String A[] = in.readLine().trim().split(" ");
		    int N = Integer.parseInt(A[0]);
		    A = in.readLine().trim().split(" ");
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isCircle(N, A));
		}
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    static boolean dfsTraversal(char ch, HashSet<Character> visited, HashMap<Character, ArrayList<Character>> m)
    {
        if(visited.contains(ch))
        return m.size() == visited.size();
        
        visited.add(ch);
        
        for(char c: m.get(ch))
        {
            if(dfsTraversal(c,visited,m))
            {
                return true;
            }
        }
        
        return false;
    }
    static int isCircle(int N, String A[])
    {
        // code here
        int inDegree[] = new int[26];
        int outDegree[] = new int[26];
        
        HashMap<Character, ArrayList<Character>> m = new HashMap<>();
        
        for (String str : A)
        {
            char firstchar = str.charAt(0);
            char lastchar = str.charAt(str.length()-1);
            
            if(!m.containsKey(firstchar))
            {
                m.put(firstchar, new ArrayList<>());
            }
            
            m.get(firstchar).add(lastchar);
            
            outDegree[firstchar-'a']++;
            inDegree[lastchar-'a']++;
            
            
        }
        
        for(int i = 0; i <26;i++)
        {
            if(inDegree[i] != outDegree[i])
            return 0;
        }
        
        HashSet<Character> visited = new HashSet<>();
        
        if(dfsTraversal(A[0].charAt(0),visited,m))
        return 1;
        
        else
        return 0;
    }
}
