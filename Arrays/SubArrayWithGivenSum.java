import java.util.*;
import java.lang.*;
import java.io.*;

class SubArraysWithGivenSum{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int beg=0, end=-1,curSum=0,i;
        HashMap<Integer,Integer> m = new HashMap<>();
        ArrayList<Integer> A = new ArrayList<>();
        for(i=0;i<n;i++)
        {
            curSum+=arr[i];
            
            if(curSum==s)
            {
                beg=0;
                end=i;
                break;
            }
            
            if(m.containsKey(curSum-s))
            {
                beg=m.get(curSum-s)+1;
                end=i;
                break;
            }
            
            m.put(curSum,i);
        }
        
        if(end==-1)
        {
            A.add(-1);
            return A;
        }
        
        else
        {
        
        A.add(beg+1);
        A.add(end+1);
        
        return A;
    }
}
}
