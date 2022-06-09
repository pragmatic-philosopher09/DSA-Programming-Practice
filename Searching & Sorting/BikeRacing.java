import java.io.*;
import java.util.*;

class BikeRacing{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            long M = Long.parseLong(a[1]);
            long L = Long.parseLong(a[2]);
            long H[] = new long[N];
            long A[] = new long[N];
            for(int i = 0; i < N; i++){
                String a1[] = in.readLine().trim().split("\\s+");
                H[i] = Long.parseLong(a1[0]);
                A[i] = Long.parseLong(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.buzzTime(N, M, L, H, A));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean checkMinThresholdValue(long T, long M, long L, long H[], long A[], int N)
    {
        long res=0;
        for(int i = 0; i < N; i++)
        {
            long val =  H[i]+A[i]*T;
            
            res += (val>=L)?val:0;
        }
        
        return (res>=M);
    }
    static long buzzTime(int N, long M, long L, long H[], long A[]){
        // code here
        
        long low, mid, high;
        low=0;
        high = M;
        
        while(low<high)
        {
            mid = low+ (high-low)/2;
            
            if(checkMinThresholdValue(mid, M, L, H, A, N))
            high=mid;
            
            else
            low=mid+1;
        }
        
        return high;
        
    }
}

