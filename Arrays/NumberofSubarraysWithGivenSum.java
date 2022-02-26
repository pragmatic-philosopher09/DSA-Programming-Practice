//Initial Template for Java

import java.io.*;
import java.util.*;

class NumberofSubArraysWithGivenSum{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        int count=0,curSum=0;
        int i;
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        for(i=0;i<N;i++)
        {
            curSum+=Arr[i];
            
        
            if(curSum==k)
            count++;
            
            if(m.containsKey(curSum-k))
            {
                int f = m.get(curSum-k);
                count+=f;
            }
            m.put(curSum,m.getOrDefault(curSum,0)+1);
        }
        
        
        
     
        
       
            return count;
        
    }
}