import java.io.*;
import java.util.*;

class TowersOfHanoiCustomizedProblem{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    ArrayList<Integer> res = new ArrayList<>();
    
    static void towersOfHanoi(int N, int box1, int box2, int box3, ArrayList<ArrayList<Integer>> r)
    {
        if(N == 0)
        return;
        
         towersOfHanoi(N-1, box1, box3, box2,r);
        ArrayList<Integer> z = new ArrayList<>();
        
        z.add(box1);
        z.add(box2);
        r.add(z);
        
        towersOfHanoi(N-1, box3,box2,box1,r);
        
       
        
    }
    static List<Integer> shiftPile(int N, int n){
        // code here
        
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        towersOfHanoi(N, 1,3,2,r);
        return r.get(n-1);
    }
}
