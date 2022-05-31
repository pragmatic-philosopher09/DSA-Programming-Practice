// Initial Template for Java

import java.io.*;
import java.util.*;

class SnakesAndLadders{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minThrow(int N, int arr[]){
        // code here
        
        HashMap<Integer,Integer> m = new HashMap<>();
        int i,j,temp;
        
        for(i = 0; i < (2*N); i+=2)
        {
            m.put(arr[i],arr[i+1]); //Putting starting point and ending point for first 'n' ladders as given in array and last 'n' snakes, respectively.
            
        }
        
        boolean visited[] = new boolean[31];
        
        Queue<Integer> q = new ArrayDeque<>();
        
        visited[1] = true;
        q.offer(1);
        
        int countOfMinMoves = 0;
        
        while(!q.isEmpty())
        {
            int s = q.size();
            
            for(i = 0; i < s; i++)
            {
                int curr = q.poll();
                
                if (curr == 30)
                return countOfMinMoves;
                
                for(j = 1; j <= 6; j++)
                {
                    temp = curr+j;
                    
                    if(temp > 30)
                    break;
                    
                    if(m.containsKey(temp) && !visited[m.get(temp)])
                    {
                        visited[temp] = true;
                        q.offer(m.get(temp));
                        visited[m.get(temp)] = true;
                    }
                    
                    else if(!visited[temp])
                    {
                        visited[temp] = true;
                        q.offer(temp);
                    }
                }
            }
            
            countOfMinMoves++;
        }
        
        return -1;
    }
}
