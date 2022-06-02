import java.util.*;
class RatInAMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    static void solveUsingBacktracking(int i, int j, int n, boolean visited[][], String move, ArrayList<String> res, int di[], int dj[], int m[][])
    {
        
        if(i==n-1 && j== n-1)
        res.add(move);
        
        String dir = "DRLU";
        for(int index = 0; index < 4; index++)
        {
            int nexti = di[index] + i;
            int nextj = dj[index] + j;
            
            if(nexti >=0 && nextj >=0 && nexti < n && nextj <n && !visited[nexti][nextj] && m[nexti][nextj]==1)
            {
                visited[i][j] = true;
                
                solveUsingBacktracking(nexti, nextj, n, visited, move+dir.charAt(index),  res, di, dj, m);
                
                visited[i][j] = false;
            }
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        
        
        boolean visited[][] = new boolean[n][n];
        ArrayList<String> res = new ArrayList<>();
        
        if(m[0][0] == 0)
        return res;
        
        int di[] = {+1, 0, 0, -1};
        int dj[] = {0, +1, -1, 0};
        
        solveUsingBacktracking(0,0,n,visited, "", res, di, dj, m);
        
        return res;
    }
}
