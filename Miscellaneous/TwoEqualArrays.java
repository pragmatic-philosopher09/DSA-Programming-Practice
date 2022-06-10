//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class TwoEqualArrays {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        HashMap<Long,Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++)
        {
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }
        
        for(int j = 0; j < N; j++)
        {
            if(!map.containsKey(B[j]))
            return false;
            
            map.put(B[j],map.get(B[j])-1);
            
            
        }
        
        for(int i = 0; i < N; i++)
        {
            if(map.get(B[i])<0)
            return false;
        }
        
        return true;
    }
}
