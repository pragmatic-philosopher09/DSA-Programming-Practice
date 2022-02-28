//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class FindMajorityElement
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        //Frequency of Elements In Array
        
        int oldFrequency, newFrequency;
        for(int i=0;i<a.length;i++)
        {
            if(map.containsKey(a[i]))
            {
                oldFrequency = map.get(a[i]);
                newFrequency = oldFrequency + 1;
                map.put(a[i], newFrequency);
            }
            
            else
            {
                map.put(a[i],1);
            }
        }
        
        // Checking Count of Elements In Array
        
        int max=0, maxElement=-1;
        
        for(int k:map.keySet())
        {
            if(map.get(k) > max)
            {
                max = map.get(k);
                maxElement = k;
            }
        }
        
        if(max > size/2)
        return maxElement;
        
        else
        return -1;
    }
}
