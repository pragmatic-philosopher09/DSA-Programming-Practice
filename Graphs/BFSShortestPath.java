import java.io.*;
import java.util.*;
class BFSShortestPath {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        
        if(A[0][0] == 0)
        return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0}); // First two points rep. (x,y) coordinates; last point denotes the path dist.
        A[0][0] = 0; //'0' denotes visited cell
        
        int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!q.isEmpty())
        {
            int s = q.size();
            
            while(s-- > 0)
            {
                int curr[] = q.poll();
                
                if(curr[0] == X && curr[1] == Y)
                {
                    return curr[2];
                }
                
                else
                {
                    for(int[] d: dir)
                    {
                        int row = d[0] + curr[0];
                        int col = d[1] + curr[1];
                        
                        if(row >=0 && col >=0 && row < N && col < M && A[row][col] == 1)
                        {
                            q.add(new int[] {row, col, curr[2]+1});
                            A[row][col] = 0; 
                        }
                        
                    }
                }
            }
        }
        
        return -1;
        }
    
};