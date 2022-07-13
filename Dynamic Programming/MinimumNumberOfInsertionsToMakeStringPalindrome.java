import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str1)
    {
       //First, find longest palindromic subsequence
       
       //Uske liye we need to first reverse the given string
       
       String str2="";
       for(int i = 0; i<str1.length();i++)
       {
           str2 = str1.charAt(i)+str2;
       }
       
       //Now, find LCS between given string and its palindrome for LPS
       int l = str1.length();
       int dp[][] = new int[l+1][l+1];
       
       for(int i = 1; i<=l;i++)
       {
           for(int j = 1; j<=l;j++)
           {
               if(str1.charAt(i-1) == str2.charAt(j-1))
               {
                   dp[i][j] = 1 + dp[i-1][j-1];
               }
               
               else
               dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
           }
       }
       
       return l-dp[l][l];
    }
}
