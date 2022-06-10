//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class CombinationSum1
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    
    static void formulatingCombinations(int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> A, int B, ArrayList<Integer> ds)
    {
        //Base Case
        
        if(index == A.size())
        {
            if(B==0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(A.get(index)<=B)
        {
            ds.add(A.get(index));
            formulatingCombinations(index, ans, A, B-A.get(index), ds);
            ds.remove(ds.size()-1);
            
        }
        
        formulatingCombinations(index+1, ans, A, B, ds);
        
        
    }
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
         HashSet <Integer> hs = new HashSet<>(A);
          ArrayList <Integer> new_A = new ArrayList<>(hs);
       Collections.sort(new_A);
        formulatingCombinations(0, ans, new_A, B, new ArrayList<>());
        
        return ans;
    }
}
