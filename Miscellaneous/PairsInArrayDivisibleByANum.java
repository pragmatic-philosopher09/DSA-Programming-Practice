import java.util.*;
import java.io.*;
import java.lang.*;

class PairsInArrayDivisibleByANum
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        long res=0;
        HashMap<Integer,Integer> m = new HashMap<>();
        
        for(int i = 0; i < n; i++)
        {
            int rem = arr[i]%k;
            
            if(m.containsKey((k-rem)%k))
            {
                res += m.get((k-rem)%k);
            }
            
            
            
            m.put(rem,m.getOrDefault(rem,0)+1);
            
            
           
        }
        
        return res;
    }
}
